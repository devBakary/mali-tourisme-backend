package com.autourducode.tourisme.security.services;

import com.autourducode.tourisme.models.Commentaire;
import com.autourducode.tourisme.repository.RepositoryCommentaire;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentaireServImplemente implements commentaireServ{

    @Autowired
    private RepositoryCommentaire repo;


    @Override
    public Commentaire creer(Commentaire commentaire) {
        return repo.save(commentaire);
    }

    @Override
    public Commentaire modifier(Commentaire commentaire, Long id) {
        return null;
    }

    @Override
    public List<Commentaire> liste() {
        return repo.findAll();
    }

    @Override
    public Iterable<Object[]> listeCommentaire() {
        return repo.listeCommentaire();
    }

    @Override
    public void supprimer(Long id) {
        repo.deleteById(id);
    }
}
