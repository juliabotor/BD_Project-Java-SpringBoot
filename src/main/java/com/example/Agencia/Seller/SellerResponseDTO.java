package com.example.Agencia.Seller;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SellerResponseDTO{
    private Long id_employee;
    private String name;
    private String cpf;
    private Date birth_date;

    private Integer workload;
    private Long id_supervisor;

    public SellerResponseDTO(Long id_employee, String name, String cpf, Date birth_date, Integer workload, Long id_supervisor) {
        this.id_employee = id_employee;
        this.name = name;
        this.cpf = cpf;
        this.birth_date = birth_date;
        this.workload = workload;
        this.id_supervisor = id_supervisor;
    }
}
