package com.odc.backend.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.ERole;
import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.Niveau;
import com.odc.backend.Models.Problematique;
import com.odc.backend.Models.Role;
import com.odc.backend.Models.Score;
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

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User a) {
        // TODO Auto-generated method stub

        User User = userRepository.findById(a.getId()).get();

        User log = userRepository.findByUsernameAndPassword(a.getUsername(), a.getPassword());

        if (log == null) {
            System.out.println("non null");

            a.setPassword(passwordEncoder().encode(a.getPassword()));

        } else {
            System.out.println(" null");

            a.setPassword(User.getPassword());

        }
        return userRepository.save(a);
        //return userRepository.save(user);
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
     Role superadmin=roleRepository.findByName(ERole.ROLE_SUPERADMIN);

            List<User>  list=new ArrayList<>();
            list.addAll(admin.getUsers());
            list.addAll(superadmin.getUsers());
        //rechList.add(admin);
        return list;
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

    @Override
    public List<Jeu> MesJeuxPreferes(Long idUser) {
        // TODO Auto-generated method stub

        User user=userRepository.findById(idUser).get();
        List<Problematique> mesPreferences=user.getPreferences();

        List<Jeu> mesJeux=new ArrayList<>();

        for (Problematique p : mesPreferences) {
            mesJeux.addAll(p.getJeux());
        }

        return mesJeux;
    }

    @Override
    public List<Jeu> MesDerniersjeux(Long idUser, Long nombre) {
        // TODO Auto-generated method stub
        User user=userRepository.findById(idUser).get();

        List<Niveau> mesNiveaux=new ArrayList<>();
        for (Score score : user.getScores()) {
            mesNiveaux.add(score.getNiveau());
        }

        List<Jeu> myLastJeux=new ArrayList<>();

        for (Niveau niveau : mesNiveaux) {
            if(!myLastJeux.contains(niveau.getJeu())){
                myLastJeux.add(niveau.getJeu());
            }
            
        }

        return myLastJeux;
    }

    @Override
    public User getByTelephone(String telephone) {
        // TODO Auto-generated method stub
        return userRepository.findByTelephone(telephone);
    }
    
}
