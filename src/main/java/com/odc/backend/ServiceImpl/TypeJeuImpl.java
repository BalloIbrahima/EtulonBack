package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.TypeJeu;
import com.odc.backend.Repository.TypeJeuRepository;
import com.odc.backend.Service.TypeJeuService;

@Service
public class TypeJeuImpl implements TypeJeuService {

    @Autowired
    TypeJeuRepository typeJeuRepository;

    @Override
    public TypeJeu saveTypeJeu(TypeJeu type) {
        // TODO Auto-generated method stub
        return typeJeuRepository.save(type);
    }

    @Override
    public TypeJeu updateTypeJeu(TypeJeu type) {
        // TODO Auto-generated method stub
        return typeJeuRepository.save(type);
    }

    @Override
    public TypeJeu getTypeJeu(Long id) {
        // TODO Auto-generated method stub
        return typeJeuRepository.findById(id).get();
    }

    @Override
    public void deleteTypeJeu(TypeJeu type) {
        // TODO Auto-generated method stub
        typeJeuRepository.delete(type);
    }

    @Override
    public List<TypeJeu> getAllTypeJeu() {
        // TODO Auto-generated method stub
        return typeJeuRepository.findAll();
    }
    
}
