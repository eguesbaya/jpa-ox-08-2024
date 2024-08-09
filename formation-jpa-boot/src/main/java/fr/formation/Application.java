package fr.formation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.CommentaireRepository;
import fr.formation.repo.FournisseurRepository;
import fr.formation.repo.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class Application implements CommandLineRunner {
    // @Autowired
    // private ProduitRepository produitRepository;

    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;
    private final CommentaireRepository commentaireRepository;

    @Override
    public void run(String... args) throws Exception {
        for (Produit produit : this.produitRepository.findAll()) {
            log.debug("Le produit {} (id = {})", produit.getName(), produit.getId());
        }

        for (Fournisseur fournisseur : this.fournisseurRepository.findAll()) {
            log.debug("Le fournisseur = {}", fournisseur.getName());
        }

        this.commentaireRepository.findAllByClientAdresseLivraisonCodePostal("75000").forEach(commentaire -> {
            log.debug("Le commentaire = {}", commentaire.getTexte());
        });


        // ---- EXAMPLE

        Fournisseur fournisseur = Fournisseur.builder().id(50).build();
        
        ExampleMatcher matcher = ExampleMatcher.matching()
            // .withMatcher("produits", match -> match.)
            .withIncludeNullValues()
        ;

        // Example<Fournisseur> example = Example.of(fournisseur);
        Example<Fournisseur> example = Example.of(fournisseur, matcher);

        for (Fournisseur f : this.fournisseurRepository.findAll(example)) {
            log.debug("{} - {}", f.getId(), f.getName());
        }


        // ---- CRITERIA API

        Specification<Fournisseur> specFournisseur = (root, cq, cb) -> {
            return cb.equal(root.get("name"), "AMAZON");
        };

        this.fournisseurRepository.findAll(specFournisseur);
    }
}
