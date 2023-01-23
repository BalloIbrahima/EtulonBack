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
import com.odc.backend.Models.Niveau;
import com.odc.backend.Models.Question;
import com.odc.backend.Service.NiveauService;
import com.odc.backend.Service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "question", description = "Les actions reslisables sur lobjet question.")
@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;

    @Autowired
    NiveauService niveauService;

    ////pour la creation d'une question.
    @ApiOperation(value = "Pour la creation d'une question.")
    @PostMapping("/add/{idniveau}")
    public ResponseEntity<?> registerQuestion(@RequestBody Question question,@PathVariable Long idniveau) {

        Niveau niveau=niveauService.getNiveau(idniveau);

        Question question2=questionService.saveQuestion(question);
        niveau.getQuestions().add(question2);
        niveauService.updateNiveau(niveau);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, question2);
    }

     ////pour la liaison d'une question a un niveau.
     @ApiOperation(value = "Pour la liaison d'une question a un niveau.")
     @PostMapping("/add/{idniveau}/{idquestion}")
     public ResponseEntity<?> registerQuestion(@PathVariable Long idniveau,@PathVariable Long idquestion) {
 
        Niveau niveau=niveauService.getNiveau(idniveau);
        Question question=questionService.getQuestion(idquestion);

        niveau.getQuestions().add(question);
        niveauService.updateNiveau(niveau);
        
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveau);
    }

    ////pour la Modification d'une question
    @ApiOperation(value = "Pour la Modification d'une question.")
    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, questionService.updateQuestion(question));
    }

    ////pour la recuperation d'une question
    @ApiOperation(value = "Pour la recuperation d'une question.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, questionService.getQuestion(id));
    }

    ////pour la suppression d'une question
    @ApiOperation(value = "Pour la suppression d'une question.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {

        Question question=questionService.getQuestion(id);
        questionService.deleteQuestion(question);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les niveaux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les questions.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllNiveau() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, questionService.getAllQuestion());
    }

    ////pour la recuperation d'une question
    @ApiOperation(value = "Pour la recuperation des reponses d'une question.")
    @GetMapping("/getReponses/{id}")
    public ResponseEntity<?> getReponsesQuestion(@PathVariable Long id) {
        Question question=questionService.getQuestion(id);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, question.getReponses());
    }


    ////pour la recuperation de la bonne reponse d'une question
    @ApiOperation(value = "Pour la recuperation de la bonne reponse d'une question.")
    @GetMapping("/getgodreponse/{id}")
    public ResponseEntity<?> getGodReponse(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, questionService.getBonneReponse(id));
    }

    ////pour la recuperation des mauvaises reponses d'une question
    @ApiOperation(value = "Pour la recuperation des mauvaises reponses d'une question.")
    @GetMapping("/getbadreponse/{id}")
    public ResponseEntity<?> getBadReponse(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, questionService.getMauvaisesReponses(id));
    }
}
