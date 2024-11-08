package dev.yassine.tp3_spring_boot.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UtilisateurImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomImage;

    private String cheminImage;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}