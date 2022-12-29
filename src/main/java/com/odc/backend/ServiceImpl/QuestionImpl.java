package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Question;
import com.odc.backend.Repository.QuestionRepository;
import com.odc.backend.Service.QuestionService;

@Service
public class QuestionImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        // TODO Auto-generated method stub
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        // TODO Auto-generated method stub
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long id) {
        // TODO Auto-generated method stub
        return questionRepository.findById(id).get();
    }

    @Override
    public void deleteQuestion(Question question) {
        // TODO Auto-generated method stub
        questionRepository.delete(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        // TODO Auto-generated method stub
        return questionRepository.findAll();
    }
    
}
