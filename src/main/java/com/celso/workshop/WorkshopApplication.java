package com.celso.workshop;

import com.celso.workshop.domain.User;
import com.celso.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WorkshopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"Celso","Celso@hotmail.com");
        User user2 = new User(null,"Ou fey","aaa@hotmail.com");
        User user3 = new User(null,"Nada","bbbbo@hotmail.com");

        userRepository.saveAll(Arrays.asList(user1,user2,user3));
    }
}
