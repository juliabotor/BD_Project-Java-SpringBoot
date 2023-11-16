package com.example.Agencia.Client;

import com.example.Agencia.Employee.EmployeeResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Client(cpf, email, name, phone_number) VALUES (:cpf, :email, :name, :phone_number)")
    void saveClientWithQuery(@Param("cpf") String cpf,
                               @Param("email") String email,
                               @Param("name") String name,
                               @Param("phone_number") String phone_number);

    @Query("SELECT new com.example.Agencia.Client.ClientResponseDTO(c.id_client, c.cpf, c.email, c.name, c.phone_number) FROM Client c")
    List<ClientResponseDTO> findAllClients();

}
