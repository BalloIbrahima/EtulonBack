package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Niveau;
import com.odc.backend.Repository.NiveauRepository;
import com.odc.backend.Service.NiveauService;

@Service
public class NiveauImpl implements NiveauService{
    
    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveau saveNiveau(Niveau niveau) {
        // TODO Auto-generated method stub
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) {
        // TODO Auto-generated method stub
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau getNiveau(Long id) {
        // TODO Auto-generated method stub
        return niveauRepository.findById(id).get();
    }

    @Override
    public void deleteNiveau(Niveau niveau) {
        // TODO Auto-generated method stub
        niveauRepository.delete(niveau);
    }

    @Override
    public List<Niveau> getAllNiveau() {
        // TODO Auto-generated method stub
        return niveauRepository.findAll();
    }
}
