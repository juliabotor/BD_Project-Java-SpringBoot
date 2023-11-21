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
        accommodationService.saveAccommodation(data.getName(), data.getStreet(), data.getDistrict(), data.getImage(), data.getNumber());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<AccommodationResponseDTO> getAllAccommodation() {
        return accommodationService.getAllAccommodation();
    }




}
