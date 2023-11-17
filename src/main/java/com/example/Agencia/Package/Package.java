package com.example.Agencia.Package;
import com.example.Agencia.Guide.Guide;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "package")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id_package")
public class Package {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_package;
    private String title;
    private String description;
    private Float price;
    private String image;

    @OneToOne
    @JoinColumn(name = "id_guide", unique = true)
    private Guide guide;

    public Package(PackageRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();
        this.id_package = data.id_package();
    }


}
