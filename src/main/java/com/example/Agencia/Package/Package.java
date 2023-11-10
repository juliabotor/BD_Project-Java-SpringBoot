package com.example.Agencia.Package;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Package")
@Entity(name = "Package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Package {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Float price;
    private String image;

    public Package(PackageRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();
        this.id = data.id();
    }


}
