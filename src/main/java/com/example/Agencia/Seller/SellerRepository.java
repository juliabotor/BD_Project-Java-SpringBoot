package com.example.Agencia.Seller;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface SellerRepository extends CrudRepository<Seller, Long> {

    Optional<Seller> findById(Long id_employee);

    @Modifying
    @Transactional
    @Query("INSERT INTO Seller(name, cpf, birth_date, workload,id_supervisor) VALUES (:name, :cpf, :birth_date, :workload,:id_supervisor)")
    void saveSellerWithQuery(@Param("name") String name,
                               @Param("cpf") String cpf,
                               @Param("birth_date") Date birth_date,
                             @Param("workload") Integer workload,
                             @Param("id_supervisor") Long id_supervisor);


    @Query("SELECT new com.example.Agencia.Seller.SellerResponseDTO(e.id_employee, e.name, e.cpf, e.birth_date, e.workload, e.id_supervisor) FROM Seller e WHERE e.workload > 0")
    List<SellerResponseDTO> findAllSellers();

    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.cpf = :cpf, e.birth_date = :birth_date, e.workload = :workload, e.id_supervisor = :id_supervisor WHERE e.id_employee = :id_employee")
    void updateSeller(@Param("id_employee") Long id_employee,
                      @Param("name") String name,
                      @Param("cpf") String cpf,
                      @Param("birth_date") Date birth_date,
                      @Param("workload") Integer workload,
                      @Param("id_supervisor") Long id_supervisor);





}
