package com.example.Agencia.Driver;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_driver")
public class Driver{

    @Id
    private Long id_driver;
    private String license_category;

    public Driver(DriverRequestDTO driverData){
        this.id_driver = driverData.id_driver();
        this.license_category = driverData.license_category();
    }

}
