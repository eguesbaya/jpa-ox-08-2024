package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProduitRepository produitRepository = context.getBean(ProduitRepository.class);

        for (Produit produit : produitRepository.findAll()) {
            System.out.println(produit.getName());
        }
    }
}
