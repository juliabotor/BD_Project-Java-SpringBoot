package com.example.Agencia.PackageAccommodation;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PackageAccommodationId implements Serializable {
    private Long id_package;
    private Long id_accommodation;

}
