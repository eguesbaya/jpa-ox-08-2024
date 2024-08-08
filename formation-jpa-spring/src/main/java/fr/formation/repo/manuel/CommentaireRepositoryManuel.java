package fr.formation.repo.manuel;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Commentaire;
import fr.formation.repo.CommentaireRepository;

public class CommentaireRepositoryManuel extends AbstractRepositoryManuel implements CommentaireRepository {
    @Override
    public List<Commentaire> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Commentaire> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Commentaire save(Commentaire entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Commentaire> findAllByClientAdresse(String codePostal) {
        // Solution avec les jointures
        // return em   .createQuery("select c from Commentaire c left join c.client cl left join cl.adresseLivraison a where a.codePostal = ?1", Commentaire.class)
        //             .setParameter(1, codePostal)
        //             .getResultList()
        // ;

        // Soluiton sans les jointures (c'est possible car dans toute la chaine, on a QUE des ToOne)
        return em   .createQuery("select c from Commentaire c where c.client.adresseLivraison.codePostal = ?1", Commentaire.class)
                    .setParameter(1, codePostal)
                    .getResultList()
        ;
    }
}
