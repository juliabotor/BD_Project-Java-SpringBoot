package com.example.Agencia.Seller;

import com.example.Agencia.Employee.EmployeeRequestDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
@Data
public class SellerEmployeeRequestDTO {
    private String name;
    private String cpf;
    private Date birth_date;
    private Integer workload;
    private Long id_supervisor;

}