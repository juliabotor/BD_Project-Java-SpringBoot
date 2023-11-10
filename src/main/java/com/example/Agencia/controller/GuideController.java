package com.example.Agencia.controller;

import com.example.Agencia.Guide.Guide;
import com.example.Agencia.Guide.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("guide")
public class GuideController {

    @Autowired
    GuideRepository repository;

    @GetMapping
    public List<Guide> getAll(){
        List<Guide> guideList = repository.findAll();
        return guideList;
    }

}
