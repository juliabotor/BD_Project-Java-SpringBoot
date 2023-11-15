package com.example.Agencia.Driver;

import com.example.Agencia.Employee.Employee;
import com.example.Agencia.Employee.EmployeeRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Driver extends Employee {

    String license_category;

    public Driver(DriverRequestDTO driverData, EmployeeRequestDTO employeeData){
        super(employeeData);
        this.license_category = driverData.license_category();
    }

}
