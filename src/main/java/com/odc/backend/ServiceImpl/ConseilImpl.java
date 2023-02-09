package com.odc.backend.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Problematique;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.ConseilRepository;
import com.odc.backend.Repository.UserRepository;
import com.odc.backend.Service.ConseilService;

@Service
public class ConseilImpl implements ConseilService {

    @Autowired
    ConseilRepository conseilRepository;

    @Autowired
    UserRepository userRepository;
    
    @Override
    public Conseil saveConseil(Conseil conseil) {
        // TODO Auto-generated method stub
        return conseilRepository.save(conseil);
    }

    @Override
    public Conseil updateConseil(Conseil conseil) {
        // TODO Auto-generated method stub
        return conseilRepository.save(conseil);
    }

    @Override
    public Conseil getConseil(Long id) {
        // TODO Auto-generated method stub
        return conseilRepository.findById(id).get();
    }

    @Override
    public void deleteConseil(Conseil conseil) {
        // TODO Auto-generated method stub
        conseilRepository.delete(conseil);
    }

    @Override
    public List<Conseil> getAllConseil() {
        // TODO Auto-generated method stub
        return conseilRepository.findAll();
    }

    @Override
    public List<Conseil> getByUserInterets(Long id) {
        // TODO Auto-generated method stub
        User user=userRepository.findById(id).get();
        List<Conseil> mesInterets=new ArrayList<>();
        List<Conseil> allConseil=conseilRepository.findAll();

        for (Problematique problematique : user.getPreferences()) {
            mesInterets.addAll(problematique.getConseils());
        }

            //ajout des autres conseils apres recuperation des interets
            for (Conseil conseil : allConseil) {
                if(!mesInterets.contains(conseil)){
                    mesInterets.add(conseil);
                }
            }
        
        
        return mesInterets;
    }

    @Override
    public List<Conseil> getByAimes(Long id) {
        // TODO Auto-generated method stub
        List<Conseil> allConseil=conseilRepository.findAllByOrderByNbreLikeDesc();


        // Collections.sort(allConseil, new Comparator<Conseil>() {

        //     @Override
        //     public int compare(Conseil arg0, Conseil arg1) {
        //         // TODO Auto-generated method stub
        //         arg0.getLikes().size().compareTo(arg1.getLikes().size());
        //     }
        // });
        
        return allConseil;
    }

    @Override
    public List<Conseil> getByUser(User user) {
        // TODO Auto-generated method stub
        return conseilRepository.findByUser(user);
    }

    @Override
    public List<Conseil> getAllConseilActive() {
        // TODO Auto-generated method stub
        return conseilRepository.findByIsValidOrderByIdDesc(true);
    }

    @Override
    public List<Conseil> getAllConseilNonActive() {
        // TODO Auto-generated method stub
        return conseilRepository.findByIsValidOrderByIdDesc(null);
    }

    @Override
    public List<Conseil> getAllConseiltRejetes() {
        // TODO Auto-generated method stub
        return conseilRepository.findByIsValidOrderByIdDesc(false);
    }

    ////Mise a  jour des likes et nbre jeu
    @Scheduled(fixedRateString = "PT01S")
    public void MiseAjour() {
        List<Conseil> allConseil=conseilRepository.findAll();
 
        for (Conseil c : allConseil) {
            c.setNbreLike((long) c.getLikes().size());
            conseilRepository.save(c);
        }
       
    }

}
