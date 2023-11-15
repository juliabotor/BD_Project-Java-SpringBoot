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

    Optional<Seller> findById(Long id);

    @Modifying
    @Transactional
    @Query("INSERT INTO Employee(name, cpf, birth_date) VALUES (:name, :cpf, :birth_date)")
    void saveSellerWithQuery(@Param("name") String name,
                               @Param("cpf") String cpf,
                               @Param("birth_date") Date birth_date);


    @Query("SELECT new com.example.Agencia.Seller.SellerResponseDTO(e.id, e.name, e.cpf, e.birth_date) FROM Seller e")
    List<SellerResponseDTO> findAllEmployees();

    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.cpf = :cpf, e.birth_date = :birth_date, e.workload = :workload WHERE e.id = :id")
    void updateSeller(@Param("id") Long id,
                        @Param("name") String name,
                        @Param("cpf") String cpf,
                        @Param("birth_date") Date birth_date,
                        @Param("workload") Integer workload);




}
