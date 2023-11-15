package com.example.Agencia.Driver;

import com.example.Agencia.Seller.SellerResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface DriverRepository extends CrudRepository<Driver,Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Employee(name, cpf, birth_date) VALUES (:name, :cpf, :birth_date)")
    void saveDriverWithQuery(@Param("name") String name,
                             @Param("cpf") String cpf,
                             @Param("birth_date") Date birth_date);


    @Query("SELECT new com.example.Agencia.Driver.DriverResponseDTO(e.id, e.name, e.cpf, e.birth_date, e.license_category) FROM Employee e WHERE e.license_category != 'NULL'")
    List<DriverResponseDTO> findAllDrivers();

    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.cpf = :cpf, e.birth_date = :birth_date, e.license_category = :license_category WHERE e.id = :id")
    void updateDriver(@Param("id") Long id,
                      @Param("name") String name,
                      @Param("cpf") String cpf,
                      @Param("birth_date") Date birth_date,
                      @Param("license_category") String license_category);



}
