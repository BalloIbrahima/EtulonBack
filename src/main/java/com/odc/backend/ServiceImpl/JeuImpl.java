package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Jeu;
import com.odc.backend.Repository.JeuRepository;
import com.odc.backend.Service.JeuService;
@Service
public class JeuImpl implements JeuService {

    @Autowired
    JeuRepository jeuRepository;

    @Override
    public Jeu saveJeu(Jeu jeu) {
        // TODO Auto-generated method stub
        return jeuRepository.save(jeu);
    }

    @Override
    public Jeu updateJeu(Jeu jeu) {
        // TODO Auto-generated method stub
        return jeuRepository.save(jeu);
    }

    @Override
    public Jeu getJeu(Long id) {
        // TODO Auto-generated method stub
        return jeuRepository.findById(id).get();
    }

    @Override
    public void deleteJeu(Jeu jeu) {
        // TODO Auto-generated method stub
        jeuRepository.delete(jeu);
    }

    @Override
    public List<Jeu> getAllJeu() {
        // TODO Auto-generated method stub
        return jeuRepository.findAll();
    }
    
}
