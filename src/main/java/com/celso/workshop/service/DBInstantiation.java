package com.celso.workshop.service;

import com.celso.workshop.domain.User;
import com.celso.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DBInstantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null,"Celso","Celso@hotmail.com");
        User user2 = new User(null,"Ou fey","aaa@hotmail.com");
        User user3 = new User(null,"Nada","bbbbo@hotmail.com");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));
    }
}
