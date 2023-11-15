package com.example.Agencia.Driver;

import com.example.Agencia.Employee.EmployeeRequestDTO;
import com.example.Agencia.Seller.SellerRequestDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
@Data
public class DriverEmployeeRequestDTO {
    private String name;
    private String cpf;
    private Date birth_date;
    private String license_category;

}