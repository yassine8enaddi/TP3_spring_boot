package dev.yassine.tp3_spring_boot.controllers;

import dev.yassine.tp3_spring_boot.models.Role;
import dev.yassine.tp3_spring_boot.models.Utilisateur;
import dev.yassine.tp3_spring_boot.models.UtilisateurImage;
import dev.yassine.tp3_spring_boot.repositories.RoleRepository;
import dev.yassine.tp3_spring_boot.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur, @RequestParam Long roleId) {
        return utilisateurService.createUtilisateur(utilisateur, roleId);
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PutMapping("/{utilisateurId}/role/{roleId}")
    public Utilisateur assignRoleToUtilisateur(@PathVariable Long utilisateurId, @PathVariable Long roleId) {
        return utilisateurService.assignRoleToUtilisateur(utilisateurId, roleId);
    }

    @PostMapping("/{utilisateurId}/image")
    public Utilisateur addImageToUtilisateur(@PathVariable Long utilisateurId, @RequestBody UtilisateurImage image) {
        return utilisateurService.addImageToUtilisateur(utilisateurId, image);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateurById(@PathVariable Long id) {
        utilisateurService.deleteUtilisateurById(id);
    }

    @DeleteMapping("/role/{roleId}")
    public void deleteRoleById(@PathVariable Long roleId) {
        utilisateurService.deleteRoleById(roleId);
    }

    @DeleteMapping("/{utilisateurId}/image/{imageId}")
    public void deleteUtilisateurImage(@PathVariable Long utilisateurId, @PathVariable Long imageId) {
        utilisateurService.deleteUtilisateurImage(utilisateurId, imageId);
    }
}
