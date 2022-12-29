package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.User;
import com.odc.backend.Repository.UserRepository;
import com.odc.backend.Service.UserService;
@Service
public class UserImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        // TODO Auto-generated method stub
        return userRepository.findByUsername(username).orElseThrow(() ->null);
    }

    @Override
    public User getByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email).orElseThrow(() ->null);
    }

    
}
