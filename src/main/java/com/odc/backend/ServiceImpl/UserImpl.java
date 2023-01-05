package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.ERole;
import com.odc.backend.Models.Role;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.RoleRepository;
import com.odc.backend.Repository.UserRepository;
import com.odc.backend.Service.UserService;
@Service
public class UserImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

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

    @Override
    public List<User> getAllAdmin() {
        // TODO Auto-generated method stub
        //Set<Role> rechList=new HashSet<>(); 
        Role admin=roleRepository.findByName(ERole.ROLE_ADMIN);
        //rechList.add(admin);
        return admin.getUsers();
    }

    @Override
    public List<User> getAllCitoyen() {
        // TODO Auto-generated method stub
        //Set<Role> rechList=new HashSet<>(); 
        Role citoyen=roleRepository.findByName(ERole.ROLE_CITOYEN);
        //rechList.add(citoyen);
        return citoyen.getUsers(); 
    }

    @Override
    public Long NombreAdmin() {
        // TODO Auto-generated method stub
        Role admin=roleRepository.findByName(ERole.ROLE_ADMIN);
        Role superadmin=roleRepository.findByName(ERole.ROLE_SUPERADMIN);

        return  (long) (admin.getUsers().size() + superadmin.getUsers().size());
    }

    @Override
    public Long NombreCitoyen() {
        // TODO Auto-generated method stub
        Role citoyen=roleRepository.findByName(ERole.ROLE_CITOYEN);
        return (long) citoyen.getUsers().size(); 
    }

    
}
