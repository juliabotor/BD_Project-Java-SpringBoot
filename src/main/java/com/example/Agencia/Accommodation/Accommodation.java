package com.example.Agencia.Accommodation;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "accommodation")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_accommodation")
public class Accommodation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_accommodation;
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
        this.id_accommodation = data.id_accommodation();
        this.image = data.image();
    }




}
