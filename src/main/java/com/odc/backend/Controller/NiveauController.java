package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Service.NiveauService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Api(value = "niveau", description = "Les actions reslisables sur lobjet niveau.")
@RestController
@RequestMapping("/niveau")
public class NiveauController {
    
    @Autowired
    NiveauService niveauService;
}
