package com.odc.backend.Controller;

import java.util.Date;

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
import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Problematique;
import com.odc.backend.Models.User;
import com.odc.backend.Service.ConseilService;
import com.odc.backend.Service.ProblematiqueService;
import com.odc.backend.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "conseil", description = "Les actions reslisables sur lobjet conseil.")
@RestController
@RequestMapping("/conseil")
public class ConseilController {
    
    @Autowired
    ConseilService conseilService;

    @Autowired
    ProblematiqueService problematiqueService;

    @Autowired
    UserService userService;

    // methode pour la création d'un conseil
    @ApiOperation(value = "Création d'un conseil.")
    @PostMapping("/add")
    public ResponseEntity<Object> creerConseil(@RequestBody Conseil conseil) {
        conseil.setDate(new Date());
        return ResponseMessage.generateResponse("Conseil ajoutée avec succes", HttpStatus.OK, conseilService.saveConseil(conseil));


    }
    // Fin

    ////pour la Modification d'un conseil
    @ApiOperation(value = "Pour la Modification d'un conseil.")
    @PutMapping("/update")
    public ResponseEntity<?> updateConseil(@RequestBody Conseil conseil) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.updateConseil(conseil));
    }

    ////pour la recuperation d'un conseil
    @ApiOperation(value = "Pour la recuperation d'un conseil.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getNiveau(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getConseil(id));
    }

    ////pour la suppression d'un conseil
    @ApiOperation(value = "Pour la suppression d'un conseil.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNiveau(@PathVariable Long id) {

        Conseil conseil=conseilService.getConseil(id);
        conseilService.deleteConseil(conseil);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les niveaux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les niveaux.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllConseil() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getAllConseil());
    }

    ////pour la recuperation des conseils en fonction d'une problematique
    @ApiOperation(value = "Pour la recuperation des conseils en fonction d'une problematique.")
    @GetMapping("/getproblematiques/{id}")
    public ResponseEntity<?> getProblematiques(@PathVariable Long id) {
        Problematique problematique=problematiqueService.getProblematique(id);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, problematique.getConseils());
    }

    ////pour la recuperation des conseils en fonction des interest d'un user
    @ApiOperation(value = "Pour la recuperation des conseils en fonction des interest d'un user.")
    @GetMapping("/getbyinterets/{id}")
    public ResponseEntity<?> getByInterets(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getByUserInterets(id));
    }

    //pour la recuperation du nombre de conseil d'un user
    @ApiOperation(value = "pour la recuperation du nombre de conseil d'un user.")
    @GetMapping("/getnombre/{idUser}")
    public ResponseEntity<?> getNombreConseil(@PathVariable Long idUser) {
        User user=userService.getUser(idUser);
        
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getByUser(user).size());
    }

    //pour la recuperation du nombre des conseils d'un user
    @ApiOperation(value = "Pour la recuperation du nombre des conseils d'un user.")
    @GetMapping("/getAllConseil/{idUser}")
    public ResponseEntity<?> getlisteConseil(@PathVariable Long idUser) {
        User user=userService.getUser(idUser);
        
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getByUser(user));
    }

    //pour la recuperation  des conseils actives
    @ApiOperation(value = "Pour la recuperation des conseils actives.")
    @GetMapping("/getConseilsActives")
    public ResponseEntity<?> getlisteConseilActive() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getAllConseilActive());
    }

    //pour la recuperation du nombre des conseils en attentes
    @ApiOperation(value = "Pour la recuperation  des conseils en attentes.")
    @GetMapping("/getConseilsAttentes")
    public ResponseEntity<?> getlisteConseilAttentes() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getAllConseilNonActive());
    }

    //pour la recuperation du nombre des conseils en attentes
    @ApiOperation(value = "Pour la recuperation  des conseils rejetes.")
    @GetMapping("/getConseilsRejetes")
    public ResponseEntity<?> getConseilsRejetes() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseilService.getAllConseiltRejetes());
    }

}
