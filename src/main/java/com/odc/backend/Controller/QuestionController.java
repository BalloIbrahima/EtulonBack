package com.odc.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.backend.Service.QuestionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;
}
