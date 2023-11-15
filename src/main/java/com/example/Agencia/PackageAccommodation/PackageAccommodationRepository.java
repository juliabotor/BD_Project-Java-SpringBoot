package com.example.Agencia.PackageAccommodation;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PackageAccommodationRepository extends CrudRepository<PackageAccommodation, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO package_accommodation(id_package, id_accommodation) VALUES (:id_package, :id_accommodation)")
    void savePackageAccommodationWithQuery(@Param("id_package") Long id_package,
                               @Param("id_accommodation") Long id_accommodation);
    @Query("SELECT NEW com.example.Agencia.PackageAccommodation.PackageAccommodationResponseDTO(p.id_package, p.title, a.id_accommodation ,a.name) " +
            "FROM com.example.Agencia.Package.Package p " +
            "JOIN com.example.Agencia.PackageAccommodation.PackageAccommodation pa ON p.id_package = pa.id_package " +
            "JOIN com.example.Agencia.Accommodation.Accommodation a ON pa.id_accommodation = a.id_accommodation")
    List<PackageAccommodationResponseDTO> findPackagesAccommodationsNames();

}
