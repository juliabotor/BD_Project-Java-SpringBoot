package com.example.Agencia.controller;

import com.example.Agencia.Driver.*;
import com.example.Agencia.Employee.EmployeeService;
import com.example.Agencia.Seller.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("driver")
public class DriverController {


    @Autowired
    private DriverRepository repository;

    @Autowired
    private DriverService driverService;


    @CrossOrigin( origins = "*" , allowedHeaders = "*")


    @GetMapping
    public List<DriverResponseDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @CrossOrigin( origins = "*" , allowedHeaders = "*")

    @PostMapping
    public void saveDriver(@RequestBody DriverRequestDTO dto) {
        Driver driver = new Driver(dto);
        driverService.saveDriver(driver.getId_driver(), driver.getLicense_category());
    }



}
