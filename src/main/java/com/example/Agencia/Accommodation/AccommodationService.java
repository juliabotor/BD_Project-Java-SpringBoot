package com.example.Agencia.Accommodation;

import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRepository;
import com.example.Agencia.Package.PackageResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    public Optional<Accommodation> findAccommodationById(Long id_accommodation) {
        return accommodationRepository.findById(id_accommodation);
    }

    public void saveAccommodation(String name, String street, String district, Integer number, String image) {
        accommodationRepository.saveAccommodationWithQuery(name, street, district, number, image);
    }

    public List<AccommodationResponseDTO> getAllAccommodation() {
        return accommodationRepository.findAllAccommodations();
    }

    @Transactional
    public void updateAccommodation(Long id_accommodation, String name, String street, String district, Integer number, String image) {
        accommodationRepository.updateAccommodation(id_accommodation, name, street, district, number, image);
    }

    @Transactional
    public void deleteAccommodationById(Long id_accommodation) {
        accommodationRepository.deleteAccommodationById(id_accommodation);
    }

}
