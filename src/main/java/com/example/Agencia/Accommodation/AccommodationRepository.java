package com.example.Agencia.Accommodation;

import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccommodationRepository extends CrudRepository<Accommodation, Long> {

    Optional<Accommodation> findById(Long id_accommodation);

    @Modifying
    @Transactional
    @Query("INSERT INTO Accommodation(name, street, district, number, image) VALUES (:name, :street, :district, :number, :image)")
    void saveAccommodationWithQuery(@Param("name") String name,
                              @Param("street") String street,
                              @Param("district") String district,
                              @Param("number") Integer number,
                              @Param("image") String image);

    @Query("SELECT new com.example.Agencia.Accommodation.AccommodationResponseDTO(a.id_accommodation, a.name, a.street, a.district, a.number, a.image) FROM Accommodation a")
    List<AccommodationResponseDTO> findAllAccommodations();

    @Modifying
    @Query("UPDATE Accommodation a SET a.name = :name, a.street = :street, a.district = :district, a.number = :number, a.image = :image WHERE a.id_accommodation = :id_accommodation")
    void updateAccommodation(@Param("id_accommodation") Long id_accommodation,
                       @Param("name") String name,
                       @Param("street") String street,
                       @Param("district") String district,
                       @Param("number") Integer number,
                       @Param("image") String image);

    @Modifying
    @Query("DELETE FROM Accommodation a WHERE a.id_accommodation = :id_accommodation")
    void deleteAccommodationById(@Param("id_accommodation") Long id_accommodation);

}
