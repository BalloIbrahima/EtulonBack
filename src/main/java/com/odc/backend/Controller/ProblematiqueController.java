package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

    ////pour la creation d'une problematique.
    @ApiOperation(value = "Pour la creation d'une problematique.")
    @PostMapping("/add")
    public ResponseEntity<?> registerProblematique(@RequestBody Problematique problematique) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematiqueService.saveProblematique(problematique));
    }

    ////pour la Modification d'une problematique
    @ApiOperation(value = "Pour la Modification d'une problematique.")
    @PostMapping("/update")
    public ResponseEntity<?> updateProblematique(@RequestBody Problematique problematique) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematiqueService.updateProblematique(problematique));
    }

    ////pour la recuperation d'une problematique
    @ApiOperation(value = "Pour la recuperation d'une problematique.")
    @PostMapping("/get/{id}")
    public ResponseEntity<?> getProblematique(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematiqueService.getProblematique(id));
    }

    ////pour la suppression d'une problematique
    @ApiOperation(value = "Pour la suppression d'une problematique.")
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteProblematique(@PathVariable Long id) {

        Problematique problematique=problematiqueService.getProblematique(id);
        problematiqueService.deleteProblematique(problematique);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les problematiques
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les problematiques.")
    @PostMapping("/getall")
    public ResponseEntity<?> getAllProblematique() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematiqueService.getAllProblematique());
    }
}
