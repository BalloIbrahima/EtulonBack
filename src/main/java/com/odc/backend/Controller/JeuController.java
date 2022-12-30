package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Service.JeuService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/jeu")
public class JeuController {
    
    @Autowired
    JeuService jeuService;
}
