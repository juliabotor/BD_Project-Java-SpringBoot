package com.example.Agencia.Seller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void saveSeller(Long id_seller, Integer workload) {
        sellerRepository.saveSeller(id_seller, workload);
    }

    public List<SellerResponseDTO> getAllSellers() {
        return sellerRepository.findAllSellers();
    }



}
