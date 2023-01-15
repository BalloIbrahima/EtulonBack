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
import com.odc.backend.Models.Question;
import com.odc.backend.Models.Reponse;
import com.odc.backend.Service.QuestionService;
import com.odc.backend.Service.ReponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "reponse", description = "Les actions reslisables sur lobjet reponse.")
@RestController
@RequestMapping("/reponse")
public class ReponseController {
    
    @Autowired
    ReponseService reponseService;

    @Autowired
    QuestionService questionService;
    ////pour la creation d'une reponse.
    @ApiOperation(value = "Pour la creation d'une reponse.")
    @PostMapping("/add/{idquestion}")
    public ResponseEntity<?> registerReponse(@RequestBody Reponse reponse,@PathVariable Long idquestion) {

        Question question=questionService.getQuestion(idquestion);

        Reponse reponse2=reponseService.saveReponse(reponse);
        question.getReponses().add(reponse2);
        questionService.updateQuestion(question);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, reponse);
    }

     ////pour la liaison d'une reponse a un niveau.
     @ApiOperation(value = "Pour la liaison d'une reponse a une question.")
     @PostMapping("/add/{idreponse}/{idquestion}")
     public ResponseEntity<?> registerReponse(@PathVariable Long idreponse,@PathVariable Long idquestion) {
 
        Reponse reponse=reponseService.getReponse(idreponse);
        Question question=questionService.getQuestion(idquestion);

        question.getReponses().add(reponse);
        questionService.updateQuestion(question);
        
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, question);
    }

    ////pour la Modification d'une reponse
    @ApiOperation(value = "Pour la Modification d'une reponse.")
    @PutMapping("/update")
    public ResponseEntity<?> updateReponse(@RequestBody Reponse reponse) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, reponseService.updateReponse(reponse));
    }

    ////pour la recuperation d'une reponse
    @ApiOperation(value = "Pour la recuperation d'une reponse.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getReponse(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, reponseService.getReponse(id));
    }

    ////pour la suppression d'une reponse
    @ApiOperation(value = "Pour la suppression d'une reponse.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReponse(@PathVariable Long id) {

        Reponse reponse=reponseService.getReponse(id);
        reponseService.deleteReponse(reponse);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les niveaux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les questions.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllReponse() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, reponseService.getAllReponse());
    }
}
