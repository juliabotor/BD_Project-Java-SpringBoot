package com.example.Agencia.Package;

import com.example.Agencia.Guide.Guide;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class PackageRequestDTO {
    private Long id_package;
    private String title;
    private String description;
    private Float price;
    private String image;
    private Long id_guide;

    public Long id_package() {
        return id_package;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public Float price() {
        return price;
    }

    public String image() {
        return image;
    }

    public Long id_guide() {
        return id_guide;
    }



}

