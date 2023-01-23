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
import com.odc.backend.Models.Commentaire;
import com.odc.backend.Models.Conseil;
import com.odc.backend.Service.CommentaireService;
import com.odc.backend.Service.ConseilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "commentaire", description = "Les actions reslisables sur lobjet commentaire.")
@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    CommentaireService commentaireService;

    @Autowired
    ConseilService conseilService;


    ////pour la creation d'un commentaire.
    @ApiOperation(value = "Pour la creation d'un commentaire.")
    @PostMapping("/add")
    public ResponseEntity<?> registerCommentaire(@RequestBody Commentaire commentaire) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, commentaireService.saveCommentaire(commentaire));
    }

    ////pour la Modification d'un commentaire
    @ApiOperation(value = "Pour la Modification d'un commentaire.")
    @PutMapping("/update")
    public ResponseEntity<?> updateCommentaire(@RequestBody Commentaire commentaire) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, commentaireService.updateCommentaire(commentaire));
    }

    ////pour la recuperation d'un commentaire
    @ApiOperation(value = "Pour la recuperation d'un commentaire.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCommentaire(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, commentaireService.getCommentaire(id));
    }

    ////pour la suppression d'un commentaire
    @ApiOperation(value = "Pour la suppression d'un commentaire.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommentaire(@PathVariable Long id) {

        Commentaire commentaire=commentaireService.getCommentaire(id);
        commentaireService.deleteCommentaire(commentaire);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les jeux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les jeux.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllCommentaires() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, commentaireService.getAllCommentaire());
    }    
    
    ////pour la recuperation d'un conseil
    @ApiOperation(value = "Pour la recuperation d'un conseil.")
    @GetMapping("/getCommentaires/{id}")
    public ResponseEntity<?> getCommentaires(@PathVariable Long id) {

        Conseil conseil=conseilService.getConseil(id);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseil.getCommentaires());
    }
}
