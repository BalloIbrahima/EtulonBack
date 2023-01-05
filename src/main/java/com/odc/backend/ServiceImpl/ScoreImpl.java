package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Score;
import com.odc.backend.Repository.ScoreRepository;
import com.odc.backend.Service.ScoreService;

@Service
public class ScoreImpl implements ScoreService {
    
    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public Score saveScore(Score score) {
        // TODO Auto-generated method stub
        return scoreRepository.save(score);
    }

    @Override
    public Score updateScore(Score score) {
        // TODO Auto-generated method stub
        return scoreRepository.save(score);
    }

    @Override
    public Score getScore(Long id) {
        // TODO Auto-generated method stub
        return scoreRepository.findById(id).get();
    }

    @Override
    public void deleteScore(Score score) {
        // TODO Auto-generated method stub
        scoreRepository.delete(score);
    }

    @Override
    public List<Score> getAllScore() {
        // TODO Auto-generated method stub
        return scoreRepository.findAll();
    }
}
