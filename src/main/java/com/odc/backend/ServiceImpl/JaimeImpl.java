package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Jaime;
import com.odc.backend.Models.Jeu;
import com.odc.backend.Repository.JaimeRepository;
import com.odc.backend.Repository.JeuRepository;
import com.odc.backend.Service.JaimeService;

@Service
public class JaimeImpl implements JaimeService{

    @Autowired
    JeuRepository jeuRepository;

    @Autowired
    JaimeRepository jaimeRepository;

    @Override
    public Jaime saveJaime(Jaime jaime) {
        // TODO Auto-generated method stub
        try {
            Jeu jeu=jaime.getNiveau().getJeu();
            if(jeu.getNbreLike()==null){
                jeu.setNbreLike(0L);
            }
            jeu.setNbreLike(jeu.getNbreLike()+1);
            jeuRepository.save(jeu);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return jaimeRepository.save(jaime);
    }

    @Override
    public Jaime updateJaime(Jaime jaime) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Jaime getJaime(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteJaime(Jaime jaime) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Jaime> getAllJaime() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
