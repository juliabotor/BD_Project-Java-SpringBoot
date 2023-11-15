package com.example.Agencia.Package;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageResponseDTO {

    private Long id_package;
    private String title;
    private String description;
    private Float price;
    private String image;


    public PackageResponseDTO(Long id_package, String title, String description, Float price, String image) {
        this.id_package = id_package;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }


}