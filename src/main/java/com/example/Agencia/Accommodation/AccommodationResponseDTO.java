package com.example.Agencia.Accommodation;

public record AccommodationResponseDTO(Long id, String image,String name, String street, String district, Integer number) {
    public AccommodationResponseDTO(Accommodation accommodation){
        this(accommodation.getId(), accommodation.getImage(), accommodation.getName(), accommodation.getStreet(), accommodation.getDistrict(), accommodation.getNumber());
    }
}
