package com.example.Agencia.Seller;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SellerResponseDTO{
    private Long id_seller;
    private Integer workload;


    public SellerResponseDTO( Long id_seller, Integer workload ) {
        this.id_seller = id_seller;
        this.workload = workload;

    }
}
