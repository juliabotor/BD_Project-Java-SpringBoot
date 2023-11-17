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

    public Optional<Employee> findEmployeeById(Long id_employee) {
        return employeeRepository.findById(id_employee);
    }

    public void saveEmployee(String name, String cpf, Date birth_date, Long id_supervisor) {
        employeeRepository.saveEmployeeWithQuery(name, cpf, birth_date, id_supervisor);
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @Transactional
    public void updateEmployee(Long id_employee, String name, String cpf, Date birth_date) {
        employeeRepository.updateEmployee(id_employee, name, cpf, birth_date);
    }

    @Transactional
    public void deleteEmployeeById(Long id_employee) {
        employeeRepository.deleteEmployeeById(id_employee);
    }
}
