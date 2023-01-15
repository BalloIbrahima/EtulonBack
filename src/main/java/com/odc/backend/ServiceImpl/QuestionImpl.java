package com.odc.backend.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Question;
import com.odc.backend.Models.Reponse;
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

    @Override
    public Reponse getBonneReponse(Long id) {
        // TODO Auto-generated method stub
        Question question= questionRepository.findById(id).get();
        Reponse bonneReponse=new Reponse();
        for (Reponse reponse : question.getReponses()) {
            if(reponse.getIsOk()){
                bonneReponse=reponse;
                break;
            }
        }

        return bonneReponse;
    }

    @Override
    public List<Reponse> getMauvaisesReponses(Long id) {
        // TODO Auto-generated method stub
        Question question= questionRepository.findById(id).get();
        List<Reponse> mauvaisesReponses=new ArrayList<>();
        for (Reponse reponse : question.getReponses()) {
            if(!reponse.getIsOk()){
                mauvaisesReponses.add(reponse);
            }
        }

        return mauvaisesReponses;
    }
    
}
