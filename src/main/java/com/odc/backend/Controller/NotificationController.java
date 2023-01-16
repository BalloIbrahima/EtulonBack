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
import com.odc.backend.Models.Notification;
import com.odc.backend.Service.ConseilService;
import com.odc.backend.Service.NotificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "notification", description = "Les actions reslisables sur l'objet notification.")
@RestController
@RequestMapping("/notification")
public class NotificationController {
    
    @Autowired
    NotificationService notificationService;

    @Autowired
    ConseilService conseilService;

    ////pour la creation d'une notifictaion.
    @ApiOperation(value = "Pour la creation d'une notifictaion.")
    @PostMapping("/add")
    public ResponseEntity<?> registerNotification(@RequestBody Notification notification) {

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, notificationService.saveNotification(notification));
    }

    ////pour la Modification d'un notification
    @ApiOperation(value = "Pour la Modification d'une notifictaion.")
    @PutMapping("/update")
    public ResponseEntity<?> updateNotification(@RequestBody Notification notification) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, notificationService.updateNotification(notification));
    }

    ////pour la recuperation d'une notifictaion
    @ApiOperation(value = "Pour la recuperation d'une notifictaion.")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getNotification(@PathVariable Long id) {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, notificationService.getNotification(id));
    }

    ////pour la suppression d'une notifictaion
    @ApiOperation(value = "Pour la suppression d'une notifictaion.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletNotifictaion(@PathVariable Long id) {

        Notification notification=notificationService.getNotification(id);
        notificationService.deleteNotification(notification);

        return ResponseMessage.generateResponse("ok", HttpStatus.OK, "Suppression effectuee !");
    }

    ////pour la recuperation de toutes les jeux
    //@PreAuthorize ("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "Pour la recuperation de toutes les jeux.")
    @GetMapping("/getall")
    public ResponseEntity<?> getAllNotifictaions() {
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, notificationService.getAllNotification());
    }    
    
    ////pour la recuperation des notification d'un user
    @ApiOperation(value = "Pour la recuperation des notification d'un user.")
    @GetMapping("/getNotifictaions/{id}")
    public ResponseEntity<?> getNotifictaions(@PathVariable Long id) {

        Conseil conseil=conseilService.getConseil(id);
        return ResponseMessage.generateResponse("ok", HttpStatus.OK, conseil.getNotification());
    }
}
