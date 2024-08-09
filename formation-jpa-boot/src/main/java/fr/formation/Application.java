package fr.formation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
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

    @Override
    public void run(String... args) throws Exception {
        for (Produit produit : this.produitRepository.findAll()) {
            log.debug("Le produit {} (id = {})", produit.getName(), produit.getId());
        }

        for (Fournisseur fournisseur : this.fournisseurRepository.findAll()) {
            log.debug("Le fournisseur = {}", fournisseur.getName());
        }
    }
}
