package com.autourducode.tourisme.repository;

import com.autourducode.tourisme.models.Commentaire;
import com.autourducode.tourisme.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCommentaire extends JpaRepository<Commentaire, Long> {


    //Requete permettant d'afficher la liste de commentaires
    @Query(value = "select commentaire.description, users.username from commentaire, users where commentaire.user = users.id", nativeQuery = true)
    Iterable<Object[]> listeCommentaire();

    @Query(value="select * from commentaire where region = ?", nativeQuery = true)
    public List<Commentaire> FindCommentaireByRegionId(Long id);
}
