package dev.yassine.tp3_spring_boot.repositories;

import dev.yassine.tp3_spring_boot.models.UtilisateurImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurImageRepository extends JpaRepository<UtilisateurImage, Long> {
}
