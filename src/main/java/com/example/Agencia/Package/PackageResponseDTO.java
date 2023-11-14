package com.example.Agencia.Package;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Float price;
    private String image;


    public PackageResponseDTO(Long id, String title, String description, Float price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }


}