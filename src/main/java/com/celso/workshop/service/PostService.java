package com.celso.workshop.service;

import com.celso.workshop.domain.Post;
import com.celso.workshop.domain.User;
import com.celso.workshop.repository.PostRepository;
import com.celso.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return  postRepository.findAll();
    }

    public Post findPost(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found! " +id));
    }
}
