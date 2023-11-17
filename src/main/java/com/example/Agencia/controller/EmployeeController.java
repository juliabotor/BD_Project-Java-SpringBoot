package com.example.Agencia.controller;
import com.example.Agencia.Employee.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeRequestDTO employeeData) {
        Employee data = new Employee(employeeData);
        employeeService.saveEmployee(data.getName(), data.getCpf(), data.getBirth_date(), data.getId_supervisor());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")


    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PutMapping
    @Transactional
    public ResponseEntity updateEmployee(@RequestBody EmployeeRequestDTO data){
        Optional<Employee> optionalEmployee = employeeService.findEmployeeById(data.id_employee());
        if (optionalEmployee.isPresent()){
            Employee employees = optionalEmployee.get();
            employees.setName(data.name());
            employees.setCpf(data.cpf());
            employees.setBirth_date(data.birth_date());
            return ResponseEntity.ok(employees);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @DeleteMapping("/{id_employee}")
    @Transactional
    public ResponseEntity deleteEmployee(@PathVariable("id_employee") Long id_employee){
        Optional<Employee> optionalEmployee = employeeService.findEmployeeById(id_employee);
        if(optionalEmployee.isPresent()){
            employeeService.deleteEmployeeById(id_employee);
            return ResponseEntity.ok("Employee deleted succesfully!");
        }
        return ResponseEntity.notFound().build();

    }

}
