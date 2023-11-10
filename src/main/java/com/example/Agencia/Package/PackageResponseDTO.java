package com.example.Agencia.Package;

public record PackageResponseDTO(Long id, String description, String image, String title, Float price) {
    public PackageResponseDTO(Package package_){
        this(package_.getId(), package_.getDescription(), package_.getImage(), package_.getTitle(), package_.getPrice());
    }
}
