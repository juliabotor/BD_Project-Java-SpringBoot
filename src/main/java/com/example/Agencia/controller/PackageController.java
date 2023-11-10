package com.example.Agencia.controller;
import com.example.Agencia.Package.PackageRepository;
import com.example.Agencia.Package.PackageRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Agencia.Package.Package;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("package")
public class PackageController {

    @Autowired
    private PackageRepository repository;

    @PostMapping
    public void savePackage(@RequestBody PackageRequestDTO data){
        Package packageData = new Package(data);
        repository.save(packageData);
        return;
    }

    @GetMapping
    public List<Package> getAll(){

        List<Package> packageList = repository.findAll();
        return packageList;

    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePackage(@RequestBody PackageRequestDTO data){
        Optional<Package> optionalPackage = repository.findById(data.id());
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



}
