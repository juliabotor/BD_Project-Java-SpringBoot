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

    public void createSeller(Seller seller) {

        System.out.println("Criando vendedor: " + seller.toString());


        sellerRepository.save(seller);
    }

    public List<SellerResponseDTO> getAllSellers() {
        return sellerRepository.findAllSellers();
    }

    @Transactional
    public void updateSeller(Long id, String name, String cpf, Date birth_date, Integer workload){
        sellerRepository.updateSeller(id, name, cpf, birth_date, workload);
    }

}