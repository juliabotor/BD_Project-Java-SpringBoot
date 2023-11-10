package com.example.Agencia.controller;
import com.example.Agencia.Package.PackageRepository;
import com.example.Agencia.Package.PackageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Agencia.Package.Package;
import java.util.List;


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

}
