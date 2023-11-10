package com.example.Agencia.controller;
import com.example.Agencia.Package.PackageRepository;
import com.example.Agencia.Package.PackageRequestDTO;
import com.example.Agencia.Package.PackageResponseDTO;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void savePackage(@RequestBody PackageRequestDTO data){
        Package packageData = new Package(data);
        repository.save(packageData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping
    public List<PackageResponseDTO> getAll(){

        List<PackageResponseDTO> packageList = repository.findAll().stream().map(PackageResponseDTO::new).toList();
        return packageList;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @DeleteMapping("/package/{id}")
    @Transactional
    public ResponseEntity deletePackage(@PathVariable("id") Long id){
        Optional<Package> optionalPackage = repository.findById(id);
        if(optionalPackage.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("Package deleted succesfully!");
        }
        return ResponseEntity.notFound().build();

    }
}
