package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Repository.ConseilRepository;
import com.odc.backend.Service.ConseilService;

@Service
public class ConseilImpl implements ConseilService {

    @Autowired
    ConseilRepository conseilRepository;

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
    
}
