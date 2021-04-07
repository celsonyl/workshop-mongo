package com.celso.workshop.service;

import com.celso.workshop.domain.Post;
import com.celso.workshop.domain.User;
import com.celso.workshop.domain.dto.AuthorDTO;
import com.celso.workshop.domain.dto.CommentDTO;
import com.celso.workshop.repository.PostRepository;
import com.celso.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class DBInstantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        User user1 = new User(null,"Celso","Celso@hotmail.com");
        User user2 = new User(null,"Zekinha","aaa@hotmail.com");
        User user3 = new User(null,"joao1010","bbbbo@hotmail.com");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));


        Post post1 = new Post(null,simpleDateFormat.parse("21/03/2018"),"Partiu Viagem!","Vou viajar para SP",new AuthorDTO(user1));
        Post post2 = new Post(null,simpleDateFormat.parse("23/03/2018"),"Bom dia!","SP",new AuthorDTO(user2));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!",simpleDateFormat.parse("02/03/2018"),new AuthorDTO(user2));
        CommentDTO comment2 = new CommentDTO("Aproveite!",simpleDateFormat.parse("22/03/2018"),new AuthorDTO(user1));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!",simpleDateFormat.parse("23/03/2018"),new AuthorDTO(user3));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1,post2));


        user1.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(user1);
    }
}
