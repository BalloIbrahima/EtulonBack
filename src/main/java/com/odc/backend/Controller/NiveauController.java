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
import com.odc.backend.Service.NiveauService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "niveau", description = "Les actions reslisables sur lobjet niveau.")
@RestController
@RequestMapping("/niveau")
public class NiveauController {
    
    @Autowired
    NiveauService niveauService;

    ////pour la creation d'un niveau.
    @ApiOperation(value = "Pour la creation d'un niveau.")
    @PostMapping("/add")
    public ResponseEntity<?> registerNiveau(@RequestBody Niveau niveau) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveauService.saveNiveau(niveau));
    }

    ////pour la Modification d'un niveau
    @ApiOperation(value = "Pour la Modification d'un niveau.")
    @PutMapping("/update")
    public ResponseEntity<?> updateNiveau(@RequestBody Niveau niveau) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveauService.updateNiveau(niveau));
    }

    ////pour la recuperation d'un niveau
    @ApiOperation(value = "Pour la recuperation d'un niveau.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getNiveau(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveauService.getNiveau(id));
    }

    ////pour la suppression d'un niveau
    @ApiOperation(value = "Pour la suppression d'un niveau.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNiveau(@PathVariable Long id) {

        Niveau niveau=niveauService.getNiveau(id);
        niveauService.deleteNiveau(niveau);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les niveaux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les niveaux.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllNiveau() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveauService.getAllNiveau());
    }

    ////pour la recuperation de toutes les question d'un niveau
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "pour la recuperation de toutes les question d'un niveau.")
    @GetMapping("/getQuestionNiveau/{idNiveau}")
    public ResponseEntity<?> getAllQuestionForNiveau(@PathVariable Long idNiveau) {
        Niveau niveau=niveauService.getNiveau(idNiveau);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, niveau.getQuestions());
    }
}
