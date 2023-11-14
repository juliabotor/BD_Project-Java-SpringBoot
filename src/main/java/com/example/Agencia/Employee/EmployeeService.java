package com.example.Agencia.Employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void saveEmployee(String name, String cpf, Date birth_date) {
        employeeRepository.saveEmployeeWithQuery(name, cpf, birth_date);
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Transactional
    public void updateEmployee(Long id, String name, String cpf, Date birth_date) {
        employeeRepository.updateEmployee(id, name, cpf, birth_date);
    }

    @Transactional
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
