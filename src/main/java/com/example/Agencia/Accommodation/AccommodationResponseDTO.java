package com.example.Agencia.Accommodation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccommodationResponseDTO {

    private Long id_accommodation;
    private String name;
    private String street;
    private String district;
    private Integer number;
    private String image;

    public AccommodationResponseDTO(Long id_accommodation, String name, String street, String district, Integer number, String image){
        this.id_accommodation = id_accommodation;
        this.name = name;
        this.image = image;
        this.district = district;
        this.street = street;
        this.number = number;
    }

}
