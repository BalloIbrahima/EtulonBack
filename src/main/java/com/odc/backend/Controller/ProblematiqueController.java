package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Message.Reponse.ResponseMessage;
import com.odc.backend.Models.Problematique;
import com.odc.backend.Service.ProblematiqueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "problematique", description = "Les actions reslisables sur lobjet problematique.")
@RestController
@RequestMapping("/problematique")
public class ProblematiqueController {
    
    @Autowired
    ProblematiqueService problematiqueService;

     ////pour la creation dun user
     @ApiOperation(value = "Pour la creation d'une problematique.")
     @PostMapping("/add")
     public ResponseEntity<?> registerUser(@RequestBody Problematique problematique) {
        try {

            return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematiqueService.saveProblematique(problematique));

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("erreur", HttpStatus.OK, "Erreur lors dde la creation .");

        }
    }
}
