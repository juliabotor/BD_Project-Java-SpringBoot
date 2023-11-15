package com.example.Agencia.controller;


import com.example.Agencia.PackageAccommodation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package_accommodation")
public class PackageAccommodationController {

    @Autowired
    private PackageAccommodationService packageAccommodationService;

    @Autowired
    private PackageAccommodationRepository packageAccommodationRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void associatePackageAccommodation(@RequestBody PackageAccommodationRequestDTO request) {
        packageAccommodationService.associatePackageAccommodation(request.getId_package(), request.getId_accommodation());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<PackageAccommodationResponseDTO> getAllPackagesAccommodations() {
        return packageAccommodationService.getAllPackagesAccommodations();
    }

}
