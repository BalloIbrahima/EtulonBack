package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Message.Reponse.ResponseMessage;
import com.odc.backend.Service.ConseilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "conseil", description = "Les actions reslisables sur lobjet conseil.")
@RestController
@RequestMapping("/conseil")
public class ConseilController {
    
    @Autowired
    ConseilService conseilService;

    // methode pour la création d'un conseil
    @ApiOperation(value = "Création d'un conseil.")
    @PostMapping("/create")
    public ResponseEntity<Object> creerConseil() {

        try {
            return ResponseMessage.generateResponse("Conseil ajoutée avec succes", HttpStatus.OK, null);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Cet conseil existe déja", HttpStatus.OK, null);
        }

    }
    // Fin
}
