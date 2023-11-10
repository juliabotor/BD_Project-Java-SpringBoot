package com.example.Agencia.Employee;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Entity(name = "employee")
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth_date;
    private String cpf;

    public Employee(EmployeeRequestDTO data){
        this.id = data.id();
        this.birth_date = data.birth_date();
        this.cpf = data.cpf();
        this.name = data.name();
    }

}
