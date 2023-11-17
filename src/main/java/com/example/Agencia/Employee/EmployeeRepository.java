package com.example.Agencia.Employee;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findById(Long id_employee);

    @Modifying
    @Transactional
    @Query("INSERT INTO Employee(name, cpf, birth_date, id_supervisor) VALUES (:name, :cpf, :birth_date, :id_supervisor)")
    void saveEmployeeWithQuery(@Param("name") String name,
                              @Param("cpf") String cpf,
                              @Param("birth_date") Date birth_date,
                               @Param("id_supervisor") Long id_supervisor);


    @Query("SELECT new com.example.Agencia.Employee.EmployeeResponseDTO(e.id_employee, e.name, e.cpf, e.birth_date, e.id_supervisor) FROM Employee e")
    List<EmployeeResponseDTO> findAllEmployees();

    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.cpf = :cpf, e.birth_date = :birth_date WHERE e.id_employee = :id_employee")
    void updateEmployee(@Param("id_employee") Long id_employee,
                       @Param("name") String name,
                       @Param("cpf") String cpf,
                       @Param("birth_date") Date birth_date);

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id_employee = :id_employee")
    void deleteEmployeeById(@Param("id_employee") Long id_employee);


}
