package com.example.Agencia.controller;

import com.example.Agencia.Guide.Guide;
import com.example.Agencia.Guide.GuideRepository;
import com.example.Agencia.Guide.GuideRequestDTO;
import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRequestDTO;
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
    public List<Guide> getAll(){
        List<Guide> guideList = repository.findAll();
        return guideList;
    }

    @PostMapping
    public void saveGuide(@RequestBody GuideRequestDTO data){
        Guide guideData = new Guide(data);
        repository.save(guideData);
        return;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateGuide(@RequestBody GuideRequestDTO data){
        Optional<Guide> optionalGuide = repository.findById(data.id());
        if (optionalGuide.isPresent()){
            Guide guide = optionalGuide.get();
            guide.setDescription(data.description());
            return ResponseEntity.ok(guide);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
