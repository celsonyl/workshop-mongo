package com.celso.workshop.service;

import com.celso.workshop.domain.Post;
import com.celso.workshop.domain.User;
import com.celso.workshop.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return  postRepository.findAll();
    }
}
