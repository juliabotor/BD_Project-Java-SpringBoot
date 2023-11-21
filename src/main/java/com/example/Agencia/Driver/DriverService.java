package com.example.Agencia.Driver;

import com.example.Agencia.Seller.Seller;
import com.example.Agencia.Seller.SellerRepository;
import com.example.Agencia.Seller.SellerResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void saveDriver(Long id_driver, String license_category) {
        driverRepository.saveDriver(id_driver, license_category);
    }

    public List<DriverResponseDTO> getAllDrivers() {
        return driverRepository.findAllDriver();
    }




}
