package com.odc.backend.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.Niveau;
import com.odc.backend.Models.Score;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.JeuRepository;
import com.odc.backend.Repository.ScoreRepository;
import com.odc.backend.Service.JeuService;
import com.odc.backend.Service.UserService;
@Service
public class JeuImpl implements JeuService {

    @Autowired
    JeuRepository jeuRepository;


    @Autowired
    UserService userService;

    @Autowired
    ScoreRepository scoreRepository;

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

    @Override
    public List<User> getAllCitoyen(Long id) {
        // TODO Auto-generated method stub
        
        Jeu jeu=jeuRepository.findById(id).get();

        List<Niveau> nList=jeu.getNiveaux();

        List<Score> sList=new ArrayList<>();

        List<User> joueurs=new ArrayList<>();


        for (Niveau n : nList) {
            sList.addAll(n.getScores());
        }

        for (Score s : sList) {
            joueurs.add(s.getUser());
        }
        
        return joueurs;
    }

    @Override
    public Long getNbreFoisJeu(Long id) {
        // TODO Auto-generated method stub

        Jeu jeu=jeuRepository.findById(id).get();

        List<Niveau> nList=jeu.getNiveaux();

        List<Score> sList=new ArrayList<>();

        for (Niveau n : nList) {
            sList.addAll(n.getScores());
        }

    
        
        return (long) sList.size();
    }

    @Override
    public Long getNbreLike(Long id) {
        // TODO Auto-generated method stub
        
        Jeu jeu=jeuRepository.findById(id).get();

        List<Niveau> nList=jeu.getNiveaux();

        List<Score> sList=new ArrayList<>();

        List<Score> likes=new ArrayList<>();


        for (Niveau n : nList) {
            sList.addAll(n.getScores());
        }

        for (Score score : sList) {
            if(score.getIsLiked()==true ){
                likes.add(score);
            }
        }
       
        return (long) likes.size();
    }

    @Override
    public List<Jeu> getNbreJeuJou(Long id) {
        // TODO Auto-generated method stub

        User user=userService.getUser(id);

        List<Score> scores=scoreRepository.findByUser(user);

        List<Jeu> jList=new ArrayList<>();

        for (Score score : scores) {
            
            if(!jList.contains(score.getNiveau().getJeu())){
                jList.add(score.getNiveau().getJeu());
            }
        }

        return jList;
    }

    @Override
    public List<Jeu> Last20Derniers() {
        // TODO Auto-generated method stub
        return jeuRepository.findTop20ByOrderByDateDesc();
    }

    @Override
    public List<Jeu> getJeuPlus() {
        // TODO Auto-generated method stub
        List<Jeu> jeuxList=jeuRepository.findTop40ByOrderByNbreJouesDesc();
        
        //list tries
        //List<Jeu> jeuTries=new ArrayList<>();


        return jeuxList;
    }



    ////Mise a  jour des likes et nbre jeu
    @Scheduled(fixedRateString = "PT02S")
    public void MiseAjour() {
        List<Jeu> jeuxList=jeuRepository.findAll();

        for (Jeu jeu : jeuxList) {

            List<Niveau> nList=jeu.getNiveaux();

            List<Score> sList=new ArrayList<>();
    
            List<Score> likes=new ArrayList<>();
    
    
            for (Niveau n : nList) {
                sList.addAll(n.getScores());
            }
    
            for (Score score : sList) {
                if(score.getIsLiked()==true ){
                    likes.add(score);
                }
            }
           
           
            System.out.println( (long) likes.size());



            jeu.setNbreJoues( (long) sList.size()); 
        
            
           
            System.out.println( (long) sList.size());
            jeu.setNbreLike( (long) likes.size());
            jeuRepository.save(jeu);
        }
    }
    
}
