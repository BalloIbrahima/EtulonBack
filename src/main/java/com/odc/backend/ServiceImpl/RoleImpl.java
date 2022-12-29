package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Role;
import com.odc.backend.Repository.RoleRepository;
import com.odc.backend.Service.RoleService;

@Service
public class RoleImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        // TODO Auto-generated method stub
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(Long id) {
        // TODO Auto-generated method stub
        return roleRepository.findById(id).get();
    }

    @Override
    public void deleteRole(Role role) {
        // TODO Auto-generated method stub
        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAllRole() {
        // TODO Auto-generated method stub
        return roleRepository.findAll();
    }
    
}
