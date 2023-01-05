package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Problematique;
import com.odc.backend.Repository.ProblematiqueRepository;
import com.odc.backend.Service.ProblematiqueService;
@Service
public class ProblematiqueImpl implements ProblematiqueService {
    
    @Autowired
    ProblematiqueRepository problematiqueRepository;

    @Override
    public Problematique saveProblematique(Problematique problematique) {
        // TODO Auto-generated method stub
        return problematiqueRepository.save(problematique);
    }

    @Override
    public Problematique updateProblematique(Problematique problematique) {
        // TODO Auto-generated method stub
        return problematiqueRepository.save(problematique);
    }

    @Override
    public Problematique getProblematique(Long id) {
        // TODO Auto-generated method stub
        return problematiqueRepository.findById(id).get();
    }

    @Override
    public void deleteProblematique(Problematique problematique) {
        // TODO Auto-generated method stub
        problematiqueRepository.delete(problematique);
    }

    @Override
    public List<Problematique> getAllProblematique() {
        // TODO Auto-generated method stub
        return problematiqueRepository.findAll();
    }

    
}
