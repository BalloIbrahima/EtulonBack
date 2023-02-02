package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Jaime;
import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.ConseilRepository;
import com.odc.backend.Repository.JaimeRepository;
import com.odc.backend.Repository.JeuRepository;
import com.odc.backend.Repository.UserRepository;
import com.odc.backend.Service.JaimeService;

@Service
public class JaimeImpl implements JaimeService{

    @Autowired
    JeuRepository jeuRepository;

    @Autowired
    JaimeRepository jaimeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConseilRepository conseilRepository;

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
        return jaimeRepository.save(jaime);
    }

    @Override
    public Jaime getJaime(Long id) {
        // TODO Auto-generated method stub
        return jaimeRepository.findById(id).get();
    }

    @Override
    public void deleteJaime(Jaime jaime) {
        // TODO Auto-generated method stub
        jaimeRepository.delete(jaime);
    }

    @Override
    public List<Jaime> getAllJaime() {
        // TODO Auto-generated method stub
        return jaimeRepository.findAll();
    }

    @Override
    public Jaime getLikeByUserAndConseil(Long idUser, Long idConseil) {
        // TODO Auto-generated method stub
        User user=userRepository.findById(idUser).get();
        Conseil conseil=conseilRepository.findById(idConseil).get();
        return jaimeRepository.findByUserAndConseil(user, conseil);
    }
    
}
