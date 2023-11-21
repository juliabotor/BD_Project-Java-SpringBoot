package com.example.Agencia.controller;
import com.example.Agencia.Employee.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/sellers")
    public List<Map<String, Object>> getAllSellersInfo() {
        String sql = "select s.id_seller, e.name, e.cpf, e.birth_date, s.workload\n" +
                "from employee e\n" +
                "join seller s on e.id_employee = s.id_seller";
        return jdbcTemplate.queryForList(sql);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/drivers")
    public List<Map<String, Object>> getAllDriversInfo() {
        String sql = "select d.id_driver, e.name, e.cpf, e.birth_date, d.license_category\n" +
                "from employee e\n" +
                "join driver d on e.id_employee = d.id_driver";
        return jdbcTemplate.queryForList(sql);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")


    @PostMapping("/add/seller")
    public ResponseEntity<String> addSeller(@RequestBody Map<String, Object> sellerData) {
        String name = (String) sellerData.get("name");
        String cpf = (String) sellerData.get("cpf");
        String birthDate = (String) sellerData.get("birth_date");
        Integer workload = (Integer) sellerData.get("workload");

        String insertSql = "INSERT INTO employee (name, cpf, birth_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql, name, cpf, birthDate);

        String selectIdSql = "SELECT LAST_INSERT_ID()";
        Long newEmployeeId = jdbcTemplate.queryForObject(selectIdSql, Long.class);

        String insertSellerSql = "INSERT INTO seller (id_seller, workload) VALUES (?, ?)";
        jdbcTemplate.update(insertSellerSql, newEmployeeId, workload);

        return new ResponseEntity<>("Vendedor adicionado com sucesso!", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping("/add/driver")
    public ResponseEntity<String> addDriver(@RequestBody Map<String, Object> driverData) {
        String name = (String) driverData.get("name");
        String cpf = (String) driverData.get("cpf");
        String birthDate = (String) driverData.get("birth_date");
        String license_category = (String) driverData.get("license_category");

        String insertSql = "INSERT INTO employee (name, cpf, birth_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql, name, cpf, birthDate);

        String selectIdSql = "SELECT LAST_INSERT_ID()";
        Long newEmployeeId = jdbcTemplate.queryForObject(selectIdSql, Long.class);

        String insertSellerSql = "INSERT INTO driver (id_driver, license_category) VALUES (?, ?)";
        jdbcTemplate.update(insertSellerSql, newEmployeeId, license_category);

        return new ResponseEntity<>("Motorista adicionado com sucesso!", HttpStatus.CREATED);
    }

}
