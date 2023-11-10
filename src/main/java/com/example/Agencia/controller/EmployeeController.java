package com.example.Agencia.controller;
import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRepository;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRequestDTO;
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
    EmployeeRepository repository;

    @GetMapping
    public List<EmployeeResponseDTO> getAll(){
        List<EmployeeResponseDTO> employeeList = repository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }

    @PostMapping
    public void saveEmployee(@RequestBody EmployeeRequestDTO data){
        Employee employeeData = new Employee(data);
        repository.save(employeeData);
        return;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateEmployee(@RequestBody EmployeeRequestDTO data){
        Optional<Employee> optionalEmployee = repository.findById(data.id());
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setName(data.name());
            employee.setCpf(data.cpf());
            employee.setBirth_date(data.birth_date());
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
