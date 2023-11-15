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

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin( origins = "*" , allowedHeaders = "*")


    @GetMapping
    public List<DriverResponseDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @CrossOrigin( origins = "*" , allowedHeaders = "*")

    @PostMapping
    public ResponseEntity<String> processData(@RequestBody DriverEmployeeRequestDTO dto) {
        try {

            Driver driver = new Driver();
            driver.setName(dto.getName());
            driver.setCpf(dto.getCpf());
            driver.setBirth_date(dto.getBirth_date());
            driver.setLicense_category(dto.getLicense_category());

            driverService.createDriver(driver);


            return ResponseEntity.ok("Dados processados com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar os dados");
        }
    }


}
