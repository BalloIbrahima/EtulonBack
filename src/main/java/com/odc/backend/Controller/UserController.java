package com.odc.backend.Controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Configuration.SpringSecurity.Jwt.JwtUtils;
import com.odc.backend.Configuration.SpringSecurity.Services.UserDetailsImpl;
import com.odc.backend.Message.Reponse.JwtResponse;
import com.odc.backend.Message.Reponse.ResponseMessage;
import com.odc.backend.Message.Requette.LoginRequest;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.RoleRepository;
import com.odc.backend.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "user", description = "Les actions reslisables par les users du systeme.")
@RestController
@RequestMapping("/user")
public class UserController {
    //private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    ////pour la creation dun user

    /////fin creation user

    // methode pour le login d'un Admin
    @ApiOperation(value = "Le login d'un user.")
    @PostMapping("/login")
    public ResponseEntity<Object> Login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        /////////////////
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),userDetails.getEmail(), userDetails.getNom(), userDetails.getPrenom(), userDetails.getPhoto(),userDetails.getPoint(),userDetails.getNiveau(),userDetails.getDateSouscription(),userDetails.getPays(), userDetails.getVille(), userDetails.getAdresse(), roles));
    }
    // Fin
    

    // methode pour la mise à jour d'un user
    @PreAuthorize ("hasRole('ROLE_ADMIN','ROLE_CITOYEN')")
    @ApiOperation(value = "Mis à jour d'un user.")
    @PutMapping("/update")
    public ResponseEntity<Object> MiseAJour(@RequestBody User user) {

        User userUpdated = userService.updateUser(user);
        return ResponseMessage.generateResponse("tilisateur modifié avec succes", HttpStatus.OK, userUpdated);

    }
    // Fin

    // methode pour la recuperation d'un user a travers son id
    @PreAuthorize ("hasRole('ROLE_ADMIN','ROLE_CITOYEN')")
    @ApiOperation(value = "recuperation d'un user a travers son id.")
    @DeleteMapping("/get/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
        try {
            return ResponseMessage.generateResponse("Utilisarteur trouve !", HttpStatus.OK, userService.getUser(id));

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la recuperation.", HttpStatus.OK, null);
        }
    }
    // Fin

    // methode pour la surpression d'un user
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Surpression d'un user.")
    @DeleteMapping("/delete")
    public ResponseEntity<Object> SuprimerUser(@RequestBody User user) {

        try {
            userService.deleteUser(user);
            return ResponseMessage.generateResponse("Utilisarteur suprimer!", HttpStatus.OK, null);

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors de la surpression.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des users
    @ApiOperation(value = "Récuperation de la liste des users.")
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @GetMapping("/liste")
    public ResponseEntity<Object> Liste(Authentication authentication) {

        try {
            return ResponseMessage.generateResponse("La liste des citoyens :", HttpStatus.OK, userService.getAllUser());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin

    // methode pour la liste des Admins
    @ApiOperation(value = "Récuperation de la liste des administrateurs.")
    @PreAuthorize ("hasRole('ROLE_ADMIN')")
    @GetMapping("/listeAdmin")
    public ResponseEntity<Object> ListeAdmin(Authentication authentication) {

        try {
            return ResponseMessage.generateResponse("La liste des admins:", HttpStatus.OK, userService.getAllAdmin());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin

    // Nombre d'admins
    @ApiOperation(value = "Récuperation du nombre d'admins.")
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @GetMapping("/nbre/admin")
    public ResponseEntity<Object> NombreAdmin(Authentication authentication) {

        try {
            return ResponseMessage.generateResponse("Le nombre d'admins:", HttpStatus.OK, userService.NombreAdmin());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour du nombre d'admins.", HttpStatus.OK, null);
        }

    }
    // Fin

    // Nombre de citoyen
    @ApiOperation(value = "Récuperation du nombre de citoyen.")
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @GetMapping("/nbre/citoyen")
    public ResponseEntity<Object> NombreCitoyen(Authentication authentication) {

        try {
            return ResponseMessage.generateResponse("Le nombre de citoyen:", HttpStatus.OK, userService.NombreCitoyen());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour du nombre de citoyen.", HttpStatus.OK, null);
        }

    }
    // Fin


    // methode pour la liste des Citoyens
    @ApiOperation(value = "Récuperation de la liste des citoyens.")
    //@PreAuthorize ("hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/listeCitoyen")
    public ResponseEntity<Object> ListeCitoyen() {

        try {
            return ResponseMessage.generateResponse("La liste des citoyens :", HttpStatus.OK, userService.getAllCitoyen());

        } catch (Exception e) {
            return ResponseMessage.generateResponse("Erreur lors du retour de la liste.", HttpStatus.OK, null);
        }

    }
    // Fin

}
