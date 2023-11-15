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

    public PackageAccommodationResponseDTO(Long id_package, String title, Long id_accommodation, String name){
        this.id_package = id_package;
        this.id_accommodation = id_accommodation;
        this.title = title;
        this.name = name;
    }

}
