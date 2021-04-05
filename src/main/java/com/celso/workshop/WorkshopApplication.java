package com.celso.workshop;

import com.celso.workshop.domain.User;
import com.celso.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WorkshopApplication{

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

}
