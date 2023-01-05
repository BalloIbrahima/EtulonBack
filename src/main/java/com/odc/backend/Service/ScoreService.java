package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Score;

public interface ScoreService {
    // Methode pour la création d'un Score
    Score saveScore(Score score);

    // Methode pour la modification d'un Score
    Score updateScore(Score score);

    // Methode pour la recuperation d'un Score
    Score getScore(Long id);

    // Methode pour la surpression d'un Score à partir d'un Score
    void deleteScore(Score score);

    // Methode pour la liste des Scores à partir d'un Score
    List<Score> getAllScore();

}
