package com.example.Agencia.Seller;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "seller")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Seller extends Employee {

    private Integer workload;

    public Seller(SellerRequestDTO sellerData, EmployeeRequestDTO data){
        super(data);
        this.workload = sellerData.workload();

    }
}