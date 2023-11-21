package com.example.Agencia.Seller;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "seller")
@Table(name = "seller")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_seller")
public class Seller{

    @Id
    private Long id_seller;

    private Integer workload;

    public Seller(SellerRequestDTO sellerData){
        this.id_seller = sellerData.id_seller();
        this.workload = sellerData.workload();

    }
}