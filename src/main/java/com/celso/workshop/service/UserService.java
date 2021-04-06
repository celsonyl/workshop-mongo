package com.celso.workshop.service;

import com.celso.workshop.domain.User;
import com.celso.workshop.domain.dto.UserDTO;
import com.celso.workshop.repository.UserRepository;
import com.celso.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return  userRepository.findAll();
    }

    public User findOne(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }

    public void insert(User obj){
        userRepository.save(obj);
    }

    public void delete(String id){
        findOne(id);
        userRepository.deleteById(id);
    }

    public User update(User obj){
       User newOBJ = findOne(obj.getId());
       updateData(newOBJ,obj);
        return userRepository.save(newOBJ);
    }

    private void updateData(User newOBJ, User obj) {
        newOBJ.setName(obj.getName());
        newOBJ.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }
}
