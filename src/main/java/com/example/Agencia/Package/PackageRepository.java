package com.example.Agencia.Package;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PackageRepository extends CrudRepository<Package, Long> {

    Optional<Package> findById(Long id_package);

    @Modifying
    @Transactional
    @Query("INSERT INTO Package(title, description, price, image) VALUES (:title, :description, :price, :image)")
    void savePackageWithQuery(@Param("title") String title,
                              @Param("description") String description,
                              @Param("price") Float price,
                              @Param("image") String image);

    @Query("SELECT new com.example.Agencia.Package.PackageResponseDTO(p.id_package, p.title, p.description, p.price, p.image) FROM Package p")
    List<PackageResponseDTO> findAllPackages();

    @Modifying
    @Query("UPDATE Package p SET p.title = :title, p.description = :description, p.price = :price, p.image = :image WHERE p.id_package = :id_package")
    void updatePackage(@Param("id_package") Long id_package,
                       @Param("title") String title,
                       @Param("description") String description,
                       @Param("price") Float price,
                       @Param("image") String image);

    @Modifying
    @Query("DELETE FROM Package p WHERE p.id_package = :id_package")
    void deletePackageById(@Param("id_package") Long id_package);

}
