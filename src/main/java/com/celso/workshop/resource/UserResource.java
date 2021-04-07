package com.celso.workshop.resource;

import com.celso.workshop.domain.Post;
import com.celso.workshop.domain.User;
import com.celso.workshop.domain.dto.UserDTO;
import com.celso.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        List<UserDTO> listDTO = users.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findOne(@PathVariable String id){
        User user = userService.findOne(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @RequestMapping(value = "/cadastro",method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO obj){
        User user = userService.fromDTO(obj);
        userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO obj, @PathVariable String id){
        User user = userService.fromDTO(obj);
        user.setId(id);
        userService.update(user);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
       userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User user = userService.findOne(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

}
