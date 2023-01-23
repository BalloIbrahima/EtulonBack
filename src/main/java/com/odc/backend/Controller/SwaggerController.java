package com.odc.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8200","http://localhost:8100"}, maxAge = 3600, allowCredentials="true")
@Api(value = "swagger", description = "Pour voir les api et leurs description.")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    @RequestMapping(method = RequestMethod.GET)
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}
