package com.example.Agencia.Guide;

public record GuideResponseDTO(Long id_guide, String description){
    public GuideResponseDTO(Guide guide){
        this(guide.getId_guide(), guide.getDescription());
    }
}
