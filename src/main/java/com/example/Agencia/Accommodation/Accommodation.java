package com.example.Agencia.Accommodation;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "accommodation")
@Entity(name = "accommodation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Accommodation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String district;
    private Integer number;
    private String image;

    public Accommodation(AccommodationRequestDTO data){
        this.district = data.district();
        this.street = data.street();
        this.number = data.number();
        this.name = data.name();
        this.id = data.id();
        this.image = data.image();
    }




}
