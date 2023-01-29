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
import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.Problematique;
import com.odc.backend.Service.JeuService;
import com.odc.backend.Service.ProblematiqueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "jeu", description = "Les actions reslisables sur lobjet jeu.")
@RestController
@RequestMapping("/jeu")
public class JeuController {
    
    @Autowired
    JeuService jeuService;

    @Autowired
    ProblematiqueService problematiqueService;


    ////pour la creation d'un jeu.
    @ApiOperation(value = "Pour la creation d'un jeu.")
    @PostMapping("/add")
    public ResponseEntity<?> registerJeu(@RequestBody Jeu jeu) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.saveJeu(jeu));
    }

    ////pour la Modification d'un jeu
    @ApiOperation(value = "Pour la Modification d'un jeu.")
    @PutMapping("/update")
    public ResponseEntity<?> updateJeu(@RequestBody Jeu jeu) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.updateJeu(jeu));
    }

    ////pour la recuperation d'un jeu
    @ApiOperation(value = "Pour la recuperation d'un jeu.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getJeu(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getJeu(id));
    }

    ////pour la suppression d'un jeu
    @ApiOperation(value = "Pour la suppression d'un jeu.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJeu(@PathVariable Long id) {

        Jeu jeu=jeuService.getJeu(id);
        jeuService.deleteJeu(jeu);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les jeux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les jeux.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllJeux() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getAllJeu());
    }

    ////pour la recuperation des jeux en fonctions dune problematique
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation des jeux en fonctions dune problematique.")
    @GetMapping("/getJeux/{idProblematique}")
    public ResponseEntity<?> getJeuxForProblematique(@PathVariable Long idProblematique) {

        Problematique problematique=problematiqueService.getProblematique(idProblematique);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematique.getJeux());
    }

    ////pour la recuperation de la liste des niveaux dun jeu
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de la liste des niveaux dun jeu.")
    @GetMapping("/getNiveaux/{id}")
    public ResponseEntity<?> getAllNIveauForJeu(@PathVariable Long id) {

        Jeu jeu=jeuService.getJeu(id);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeu.getNiveaux());
    }

    ////pour la recuperation de tout les citoyens dun jeu
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les joueurs dun jeu.")
    @GetMapping("/getcitoyens/{id}")
    public ResponseEntity<?> getAllCitiyenForJeu(@PathVariable Long id) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getAllCitoyen(id));
    }
    
    ////pour la recuperation du nombre de fois ou le jeu a ere joue
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation du nombre de fois ou le jeu a ete joue.")
    @GetMapping("/getNbreFois/{id}")
    public ResponseEntity<?> getNbreFoisJeux(@PathVariable Long id) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getNbreFoisJeu(id));
    }

    ////pour la recuperation du nombre de like dun jeu
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation du nombre de like dun jeu.")
    @GetMapping("/getNbreLike/{id}")
    public ResponseEntity<?> getNbreLike(@PathVariable Long id) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getNbreLike(id));
    }

    //pour la recuperation du nombre de jeux joues par un joueur
    @ApiOperation(value = "Pour la recuperation du nombre de jeux joues par un joueur.")
    @GetMapping("/getNbreJeu/{idUser}")
    public ResponseEntity<?> getNbreJeuJoue(@PathVariable Long idUser) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, jeuService.getNbreJeuJou(idUser).size());
    }
    
}
