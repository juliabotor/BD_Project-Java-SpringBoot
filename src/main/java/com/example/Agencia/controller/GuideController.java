package com.example.Agencia.controller;

import com.example.Agencia.Guide.Guide;
import com.example.Agencia.Guide.GuideRepository;
import com.example.Agencia.Guide.GuideRequestDTO;
import com.example.Agencia.Guide.GuideResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("guide")
public class GuideController {

    @Autowired
    GuideRepository repository;

    @GetMapping
    public List<GuideResponseDTO> getAll(){
        List<GuideResponseDTO> guideList = repository.findAllGuides();
        return guideList;
    }

    @PostMapping
    public void saveGuide(@RequestBody GuideRequestDTO data){
        Guide guideData = new Guide(data);
        repository.saveGuide(guideData.getDescription());
        return;
    }


}
