package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Message.Reponse.ResponseMessage;
import com.odc.backend.Models.Score;
import com.odc.backend.Service.ScoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "score", description = "Les actions reslisables sur lobjet score.")
@RestController
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired
    ScoreService scoreService;

    ////pour la creation d'un score.
    @ApiOperation(value = "Pour la creation d'un score.")
 @PostMapping("/add")
 
public ResponseEntity<?> registerScore(@RequestBody Score score) {

     
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.saveScore(score));
    }


    ////pour la Modification d'un score
    @ApiOperation(value = "Pour la Modification d'un score.")
    @PutMapping("/update")
    public ResponseEntity<?> updateScore(@RequestBody Score score) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.updateScore(score));
    }

    ////pour la recuperation d'un score
    @ApiOperation(value = "Pour la recuperation d'un score.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getScore(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.getScore(id));
    }

    ////pour la suppression d'un score
    @ApiOperation(value = "Pour la suppression d'un score.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteScore(@PathVariable Long id) {

        Score score=scoreService.getScore(id);
        scoreService.deleteScore(score);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de touts les scores
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les scores.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllScore() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.getAllScore());
    }

    ////pour l'affichage du score d'un user
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les scores.")
    @GetMapping("/getscore/{iduser}")
    public ResponseEntity<?> getUserScore(@PathVariable Long iduser) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.getUserScore(iduser));
    }

    ////pour l'affichage du nombre de jminute joue d'un user
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour l'affichage du nombre de minute joue d'un user.")
    @GetMapping("/getminute/{iduser}")
    public ResponseEntity<?> getTotalMinutes(@PathVariable Long iduser) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, scoreService.getTotalDurres(iduser));
    }

}
