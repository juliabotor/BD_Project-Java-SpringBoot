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

    public void saveAccommodation(String name, String street, String district, String image, Integer number) {
        accommodationRepository.saveAccommodation(name, street, district, image, number);
    }

    public List<AccommodationResponseDTO> getAllAccommodation() {
        return accommodationRepository.findAllAccommodations();
    }


}
