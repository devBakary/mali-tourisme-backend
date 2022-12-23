package com.autourducode.tourisme.security.services;


import com.autourducode.tourisme.models.Commentaire;

import java.util.List;

public interface commentaireServ {

    Commentaire creer(Commentaire commentaire);

    Commentaire modifier(Commentaire commentaire, Long id);

    List<Commentaire> liste();

    Iterable<Object[]> listeCommentaire();

    void supprimer(Long id);
}
