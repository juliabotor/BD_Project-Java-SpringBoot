package com.example.Agencia.controller;

import com.example.Agencia.Driver.Driver;
import com.example.Agencia.Driver.DriverRepository;
import com.example.Agencia.Driver.DriverRequestDTO;
import com.example.Agencia.Driver.DriverResponseDTO;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import com.example.Agencia.Seller.Seller;
import com.example.Agencia.Seller.SellerRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverRepository repository;

    @GetMapping
    public List<DriverResponseDTO> getAll(){
        List<DriverResponseDTO> driverList = repository.findAll().stream().map(DriverResponseDTO::new).toList();
        return driverList;
    }

    @PostMapping
    public void saveDriver(@RequestBody DriverRequestDTO dataDriver, EmployeeRequestDTO dataEmployee){
        Driver driverData = new Driver(dataDriver, dataEmployee);
        repository.save(driverData);
        return;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDriver(@RequestBody DriverRequestDTO dataDriver){
        Optional<Driver> optionalDriver = repository.findById(dataDriver.id());
        if(optionalDriver.isPresent()){
            Driver driver = optionalDriver.get();
            driver.setLicense_category(dataDriver.license_category());
            return ResponseEntity.ok(driver);

        }else{
            return ResponseEntity.notFound().build();
        }

    }



}
