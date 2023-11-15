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

    public void createDriver(Driver driver) {
        System.out.println("Criando Motorista: " + driver.toString());


        driverRepository.save(driver);
    }

    public List<DriverResponseDTO> getAllDrivers() {
        return driverRepository.findAllDrivers();
    }

    @Transactional
    public void updateDriver(Long id, String name, String cpf, Date birth_date, String license_category){
        driverRepository.updateDriver(id, name, cpf, birth_date, license_category);
    }


}
