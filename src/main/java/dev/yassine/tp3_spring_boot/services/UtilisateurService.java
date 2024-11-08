package dev.yassine.tp3_spring_boot.services;

import dev.yassine.tp3_spring_boot.models.Role;
import dev.yassine.tp3_spring_boot.models.Utilisateur;
import dev.yassine.tp3_spring_boot.models.UtilisateurImage;
import dev.yassine.tp3_spring_boot.repositories.RoleRepository;
import dev.yassine.tp3_spring_boot.repositories.UtilisateurImageRepository;
import dev.yassine.tp3_spring_boot.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final UtilisateurImageRepository utilisateurImageRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur, Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
    }

    public Utilisateur assignRoleToUtilisateur(Long utilisateurId, Long roleId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur addImageToUtilisateur(Long utilisateurId, UtilisateurImage image) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        image.setUtilisateur(utilisateur);
        utilisateur.setUtilisateurImage(image);
        utilisateurImageRepository.save(image);
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateurById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    public void deleteUtilisateurImage(Long utilisateurId, Long imageId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        if (utilisateur.getUtilisateurImage() != null && utilisateur.getUtilisateurImage().getId().equals(imageId)) {
            utilisateurImageRepository.deleteById(imageId);
            utilisateur.setUtilisateurImage(null);
            utilisateurRepository.save(utilisateur);
        } else {
            throw new RuntimeException("Image not found for this utilisateur");
        }
    }

    public List<Utilisateur> getUtilisateursByRole(String roleName) {
        Role role = roleRepository.findByNom(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return role.getUtilisateurs();
    }
}