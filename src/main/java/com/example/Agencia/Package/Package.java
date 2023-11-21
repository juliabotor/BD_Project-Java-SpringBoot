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


    private Long id_guide;

    public Package(PackageRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();
        this.id_package = data.id_package();
        this.id_guide = data.getId_guide();
    }


}
