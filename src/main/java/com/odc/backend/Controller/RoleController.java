package com.odc.backend.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Service.RoleService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "role", description = "Les actions reslisables sur lobjet role.")
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    RoleService roleService;
}
