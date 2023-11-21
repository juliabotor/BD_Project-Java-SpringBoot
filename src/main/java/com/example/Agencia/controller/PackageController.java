package com.example.Agencia.controller;

import com.example.Agencia.Package.PackageRequestDTO;
import com.example.Agencia.Package.PackageResponseDTO;
import com.example.Agencia.Package.PackageService;
import com.example.Agencia.Package.Package;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void savePackage(@RequestBody PackageRequestDTO packageData) {
        Package data = new Package(packageData);
        packageService.savePackage(data.getTitle(), data.getDescription(), data.getPrice(), data.getImage(), data.getId_guide());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<PackageResponseDTO> getAllPackages() {
        return packageService.getAllPackages();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PutMapping
    @Transactional
    public ResponseEntity updatePackage(@RequestBody PackageRequestDTO data){
        Optional<Package> optionalPackage = packageService.findPackageById(data.id_package());
        if (optionalPackage.isPresent()){
            Package packages = optionalPackage.get();
            packages.setTitle(data.title());
            packages.setPrice(data.price());
            packages.setDescription(data.description());
            packages.setImage(data.image());
            return ResponseEntity.ok(packages);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePackage(@PathVariable("id_package") Long id_package){
        Optional<Package> optionalPackage = packageService.findPackageById(id_package);
        if(optionalPackage.isPresent()){
            packageService.deletePackageById(id_package);
            return ResponseEntity.ok("Package deleted succesfully!");
        }
        return ResponseEntity.notFound().build();

    }


}
