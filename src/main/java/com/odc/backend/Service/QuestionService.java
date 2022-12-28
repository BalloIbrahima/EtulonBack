package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Question;

public interface QuestionService {
    
    // Methode pour la création d'un question
    Question saveQuestion(Question question);

    // Methode pour la modification d'un question
    Question updateQuestion(Question question);

    // Methode pour la recuperation d'un question
    Question getQuestion(Long id);

    // Methode pour la surpression d'un question à partir d'un question
    void deleteQuestion(Question question);

    // Methode pour la liste des questions à partir d'un question
    List<Question> getAllQuestion();
}
