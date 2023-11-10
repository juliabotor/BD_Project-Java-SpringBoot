package com.example.Agencia.Guide;

public record GuideResponseDTO(Long id, String description){
    public GuideResponseDTO(Guide guide){
        this(guide.getId(), guide.getDescription());
    }
}
