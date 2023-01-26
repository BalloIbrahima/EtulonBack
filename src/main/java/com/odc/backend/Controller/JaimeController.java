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
import com.odc.backend.Models.Jaime;
import com.odc.backend.Service.JaimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "jaime", description = "Les actions reslisables sur lobjet jaime.")
@RestController
@RequestMapping("/jaime")
public class JaimeController {
    
     
    @Autowired
    JaimeService jaimeService;

    // methode pour la création d'un jaime
    @ApiOperation(value = "Création d'un jaime.")
    @PostMapping("/add")
    public ResponseEntity<Object> creerJaime(@RequestBody Jaime jaime) {

        return ResponseMessage.generateResponse("jaime ajoutée avec succes", HttpStatus.OK, jaimeService.saveJaime(jaime));


    }
    // Fin

    ////pour la Modification d'un jaime
    @ApiOperation(value = "Pour la Modification d'un jaime.")
    @PutMapping("/update")
    public ResponseEntity<?> updateJaime(@RequestBody Jaime jaime) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jaimeService.updateJaime(jaime));
    }

    ////pour la recuperation d'un jaime
    @ApiOperation(value = "Pour la recuperation d'un jaime.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getJaime(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jaimeService.getJaime(id));
    }

    ////pour la suppression d'un jaime
    @ApiOperation(value = "Pour la suppression d'un jaime.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJaime(@PathVariable Long id) {

        Jaime jaime=jaimeService.getJaime(id);
        jaimeService.deleteJaime(jaime);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les Jaimex
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les Jaimes.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAlljaime() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jaimeService.getAllJaime());
    }


}
