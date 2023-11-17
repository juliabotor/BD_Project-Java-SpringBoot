package com.example.Agencia.Guide;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "guide")
@Entity(name = "guide")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_guide")
public class Guide {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_guide;
    private String description;

    public Guide(GuideRequestDTO data){
        this.id_guide = data.id_guide();
        this.description = data.description();
    }

}
