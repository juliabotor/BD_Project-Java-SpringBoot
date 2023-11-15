package com.example.Agencia.controller;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import com.example.Agencia.Employee.EmployeeService;
import com.example.Agencia.Seller.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("seller")
public class SellerController {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin( origins = "*" , allowedHeaders = "*")


    @GetMapping
    public List<SellerResponseDTO> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @CrossOrigin( origins = "*" , allowedHeaders = "*")

    @PostMapping
    public ResponseEntity<String> processData(@RequestBody SellerEmployeeRequestDTO dto) {
        try {

                    Seller seller = new Seller();
                    seller.setName(dto.getName());
                    seller.setCpf(dto.getCpf());
                    seller.setBirth_date(dto.getBirth_date());
                    seller.setWorkload(dto.getWorkload());

                    sellerService.createSeller(seller);


            return ResponseEntity.ok("Dados processados com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar os dados");
        }
    }


}