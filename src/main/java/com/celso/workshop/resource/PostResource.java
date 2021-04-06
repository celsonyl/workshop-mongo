package com.celso.workshop.resource;

import com.celso.workshop.domain.Post;
import com.celso.workshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
