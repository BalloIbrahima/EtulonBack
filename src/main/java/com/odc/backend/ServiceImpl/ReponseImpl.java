package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Reponse;
import com.odc.backend.Repository.ReponseRepository;
import com.odc.backend.Service.ReponseService;

@Service
public class ReponseImpl implements ReponseService{
    
    @Autowired
    ReponseRepository reponseRepository;

    @Override
    public Reponse saveReponse(Reponse reponse) {
        // TODO Auto-generated method stub
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse updateReponse(Reponse reponse) {
        // TODO Auto-generated method stub
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse getReponse(Long id) {
        // TODO Auto-generated method stub
        return reponseRepository.findById(id).get();
    }

    @Override
    public void deleteReponse(Reponse reponse) {
        // TODO Auto-generated method stub
        reponseRepository.delete(reponse);
    }

    @Override
    public List<Reponse> getAllReponse() {
        // TODO Auto-generated method stub
        return reponseRepository.findAll();
    }
    
}
