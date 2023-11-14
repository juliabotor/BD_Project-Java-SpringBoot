package com.example.Agencia.Package;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Optional<Package> findPackageById(Long id) {
        return packageRepository.findById(id);
    }

    public void savePackage(String title, String description, Float price, String image) {
        packageRepository.savePackageWithQuery(title, description, price, image);
    }

    public List<PackageResponseDTO> getAllPackages() {
        return packageRepository.findAllPackages();
    }

    @Transactional
    public void updatePackage(Long id, String title, String description, Float price, String image) {
        packageRepository.updatePackage(id, title, description, price, image);
    }

    @Transactional
    public void deletePackageById(Long id) {
        packageRepository.deletePackageById(id);
    }
}
