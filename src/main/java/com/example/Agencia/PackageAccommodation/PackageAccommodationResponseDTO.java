package com.example.Agencia.PackageAccommodation;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageAccommodationResponseDTO {

    private Long id_package;
    private Long id_accommodation;
    private String title;
    private String name;
    private String description;
    private String image;
    private Float price;

    public PackageAccommodationResponseDTO(Long id_package, String title, String description, Float price, String image, Long id_accommodation, String name){
        this.id_package = id_package;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.id_accommodation = id_accommodation;
        this.name = name;

    }

}
