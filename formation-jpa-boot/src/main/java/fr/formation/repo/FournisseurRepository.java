package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    public List<Fournisseur> findAllByProduitsCommentairesNote(int note);

    public List<Fournisseur> findByIdInAndNameIsNull(List<Integer> ids);

    @Query("select f from Fournisseur f where f.name = ?1")
    public Fournisseur findByNom(String nom);

    @Query(value = "select * from fournisseur where name = ?1", nativeQuery = true)
    public Fournisseur findByNomNative(String nom);
}
