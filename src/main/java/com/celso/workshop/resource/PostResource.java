package com.celso.workshop.resource;

import com.celso.workshop.domain.Post;
import com.celso.workshop.resource.util.URL;
import com.celso.workshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> post = postService.findAll();

        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findPost(@PathVariable String id){
        Post post = postService.findPost(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titleSearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.search(text);

        return ResponseEntity.ok().body(list);
    }


}
