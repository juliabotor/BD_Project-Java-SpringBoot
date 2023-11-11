package com.example.Agencia.controller;

import com.example.Agencia.Accommodation.Accommodation;
import com.example.Agencia.Accommodation.AccommodationRepository;
import com.example.Agencia.Accommodation.AccommodationRequestDTO;
import com.example.Agencia.Accommodation.AccommodationResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("accommodation")
public class AccommodationController {

    @Autowired
    private AccommodationRepository repository;

    @GetMapping
    public List<AccommodationResponseDTO> getAll(){
        List<AccommodationResponseDTO> accommodationList = repository.findAll().stream().map(AccommodationResponseDTO::new).toList();
        return accommodationList;
    }

    @PostMapping
    public void saveAccommodation(@RequestBody AccommodationRequestDTO data){
        Accommodation accommodationData = new Accommodation(data);
        repository.save(accommodationData);
        return;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateAccommodation(@RequestBody AccommodationRequestDTO data){
        Optional<Accommodation> optionalAccommodation = repository.findById(data.id());
        if(optionalAccommodation.isPresent()){
            Accommodation accommodation = optionalAccommodation.get();
            accommodation.setDistrict(data.district());
            accommodation.setName(data.name());
            accommodation.setStreet(data.street());
            accommodation.setNumber(data.number());
            accommodation.setImage(data.image());
            return ResponseEntity.ok(accommodation);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
