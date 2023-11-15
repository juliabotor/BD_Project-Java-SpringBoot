package com.example.Agencia.PackageAccommodation;

import com.example.Agencia.Accommodation.Accommodation;
import com.example.Agencia.Package.Package;
import jakarta.persistence.*;
import lombok.*;

@Table(name="package_accommodation")
@Entity(name="package_accommodation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PackageAccommodationId.class)
public class PackageAccommodation {

    @Id
    private Long id_package;
    @Id
    private Long id_accommodation;


}
