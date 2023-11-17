package com.example.Agencia.Employee;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth_date;
    private String cpf;

    @Column(name = "id_supervisor")
    private Long id_supervisor;

    public Employee(EmployeeRequestDTO data) {
        this.id_employee = data.id_employee();
        this.birth_date = data.birth_date();
        this.cpf = data.cpf();
        this.name = data.name();
        this.id_supervisor = data.id_supervisor();
    }


}
