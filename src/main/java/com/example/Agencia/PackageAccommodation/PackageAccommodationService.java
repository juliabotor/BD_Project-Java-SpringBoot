package com.example.Agencia.PackageAccommodation;

import com.example.Agencia.Accommodation.Accommodation;
import com.example.Agencia.Accommodation.AccommodationRepository;
import com.example.Agencia.Employee.EmployeeResponseDTO;
import com.example.Agencia.Package.Package;
import com.example.Agencia.Package.PackageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageAccommodationService {

    @Autowired
    private PackageAccommodationRepository packageAccommodationRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    public void associatePackageAccommodation(Long id_package, Long id_accommodation) {

            packageAccommodationRepository.savePackageAccommodationWithQuery(id_package, id_accommodation);

    }

    public List<PackageAccommodationResponseDTO> getAllPackagesAccommodations() {
        return packageAccommodationRepository.findPackagesAccommodationsNames();
    }


}
