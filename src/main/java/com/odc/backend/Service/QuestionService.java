package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Question;
import com.odc.backend.Models.Reponse;

public interface QuestionService {
    
    // Methode pour la création d'une question
    Question saveQuestion(Question question);

    // Methode pour la modification d'une question
    Question updateQuestion(Question question);

    // Methode pour la recuperation d'une question
    Question getQuestion(Long id);

    // Methode pour la recuperation de la bonne reponse d'une question
    Reponse getBonneReponse(Long id);

    // Methode pour la recuperation des mauvaises reponses d'une question
    List<Reponse> getMauvaisesReponses(Long id);


    // Methode pour la surpression d'une question à partir d'une question
    void deleteQuestion(Question question);

    // Methode pour la liste des questions à partir d'une question
    List<Question> getAllQuestion();
}
