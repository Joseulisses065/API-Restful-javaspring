package com.aula.worshopmongo.services;

import com.aula.worshopmongo.domain.User;
import com.aula.worshopmongo.dto.UserDTO;
import com.aula.worshopmongo.repositories.UserRepository;
import com.aula.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public  User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser,user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
    }

    public User fromDto(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }


}
