package com.example.Agencia.controller;

import com.example.Agencia.Accommodation.*;
import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRequestDTO;
import com.example.Agencia.Package.PackageResponseDTO;
import com.example.Agencia.Package.PackageService;
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
    private AccommodationService accommodationService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveAccommodation(@RequestBody AccommodationRequestDTO accommodationData) {
        Accommodation data = new Accommodation(accommodationData);
        accommodationService.saveAccommodation(data.getName(), data.getStreet(), data.getDistrict(), data.getNumber(), data.getImage());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<AccommodationResponseDTO> getAllAccommodation() {
        return accommodationService.getAllAccommodation();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PutMapping
    @Transactional
    public ResponseEntity updateAccommodation(@RequestBody AccommodationRequestDTO data){
        Optional<Accommodation> optionalAccommodation = accommodationService.findAccommodationById(data.id_accommodation());
        if (optionalAccommodation.isPresent()){
            Accommodation accommodations = optionalAccommodation.get();
            accommodations.setName(data.name());
            accommodations.setStreet(data.street());
            accommodations.setDistrict(data.district());
            accommodations.setNumber(data.number());
            accommodations.setImage(data.image());
            return ResponseEntity.ok(accommodations);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAccommodation(@PathVariable("id_accommodation") Long id_accommodation){
        Optional<Accommodation> optionalAccommodation = accommodationService.findAccommodationById(id_accommodation);
        if(optionalAccommodation.isPresent()){
            accommodationService.deleteAccommodationById(id_accommodation);
            return ResponseEntity.ok("'Accommodation' deleted succesfully!");
        }
        return ResponseEntity.notFound().build();

    }

}
