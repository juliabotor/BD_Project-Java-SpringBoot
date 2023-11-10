package com.example.Agencia.Guide;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "roteiro")
@Entity(name = "roteiro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Guide {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Guide(GuideRequestDTO data){
        this.id = data.id();
        this.description = data.description();
    }

}
