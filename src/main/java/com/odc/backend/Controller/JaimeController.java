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
import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Jaime;
import com.odc.backend.Models.Niveau;
import com.odc.backend.Models.User;
import com.odc.backend.Service.ConseilService;
import com.odc.backend.Service.JaimeService;
import com.odc.backend.Service.NiveauService;
import com.odc.backend.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "jaime", description = "Les actions reslisables sur lobjet jaime.")
@RestController
@RequestMapping("/jaime")
public class JaimeController {
    
     
    @Autowired
    JaimeService jaimeService;

    @Autowired
    UserService userService;

    @Autowired
    ConseilService conseilService;

    @Autowired
    NiveauService niveauService;

    // methode pour la création d'un jaime
    @ApiOperation(value = "Création d'un jaime.")
    @PostMapping("/addConseil/{idconseil}")
    public ResponseEntity<Object> creerJaimeConseil(@RequestBody Jaime jaime,@PathVariable Long idconseil) {

        Conseil conseil=conseilService.getConseil(idconseil);
        jaime.setConseil(conseil);
        return ResponseMessage.generateResponse("jaime ajoutée avec succes", HttpStatus.OK, jaimeService.saveJaime(jaime));


    }
    // Fin

    // methode pour la création d'un jaime
    @ApiOperation(value = "Création d'un jaime.")
    @PostMapping("/addNiveau/{idniveau}")
    public ResponseEntity<Object> creerJaimeNiveau(@RequestBody Jaime jaime,@PathVariable Long idniveau) {

        Niveau niveau=niveauService.getNiveau(idniveau);
        jaime.setNiveau(niveau);
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
    @DeleteMapping("/delete/{idUser}/{idConseil}")
    public ResponseEntity<?> deleteJaime(@PathVariable Long idUser,@PathVariable Long idConseil) {
        
        Jaime jaime=jaimeService.getLikeByUserAndConseil(idUser,idConseil);
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


    ////pour la recuperation des jaimes d'un user
    @ApiOperation(value ="Pour la recuperation des jaimes d'un users.")
    @GetMapping("/getuser/{idUser}")
    public ResponseEntity<?> getUsersJaime(@PathVariable Long idUser) {
        
        User citoyen=userService.getUser(idUser);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, citoyen.getLikes());
    }

    ////pour la verification dun jaime a travers le conseil et le user
    @ApiOperation(value = "Pour la verification dun jaime a travers le conseil et le user.")
    @GetMapping("/isliked/{idUser}/{idConseil}")
    public ResponseEntity<?> VerifyJaime(@PathVariable Long idUser,@PathVariable Long idConseil) {
        System.out.println(idConseil);
        System.out.println(idUser);

        Jaime jaime=jaimeService.getLikeByUserAndConseil(idUser,idConseil);
        System.out.println("here");
        System.out.println(jaime);
        if(jaime!=null){
            return ResponseMessage.generateResponse("ok", HttpStatus.OK, true);
        }else{
            return ResponseMessage.generateResponse("ok", HttpStatus.OK, false);
        }
        //jaimeService.deleteJaime(jaime);

    }


}
