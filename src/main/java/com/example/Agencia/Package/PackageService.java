package com.example.Agencia.Package;

import com.example.Agencia.Guide.Guide;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Optional<Package> findPackageById(Long id_package) {
        return packageRepository.findById(id_package);
    }

    public void savePackage(String title, String description, Float price, String image, Long id_guide) {
        packageRepository.savePackage(title, description, price, image, id_guide);
    }

    public List<PackageResponseDTO> getAllPackages() {
        return packageRepository.findAllPackages();
    }

    @Transactional
    public void updatePackage(Long id_package, String title, String description, Float price, String image) {
        packageRepository.updatePackage(id_package, title, description, price, image);
    }

    @Transactional
    public void deletePackageById(Long id_package) {
        packageRepository.deletePackageById(id_package);
    }
}
