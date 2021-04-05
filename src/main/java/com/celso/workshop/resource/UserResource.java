package com.celso.workshop.resource;

import com.celso.workshop.domain.User;
import com.celso.workshop.domain.dto.UserDTO;
import com.celso.workshop.repository.UserRepository;
import com.celso.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
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

}
