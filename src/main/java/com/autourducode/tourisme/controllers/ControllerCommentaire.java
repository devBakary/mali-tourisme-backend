package com.autourducode.tourisme.controllers;


import com.autourducode.tourisme.models.Commentaire;
import com.autourducode.tourisme.models.User;
import com.autourducode.tourisme.models.region;
import com.autourducode.tourisme.repository.RepositoryCommentaire;
import com.autourducode.tourisme.security.services.commentaireServ;
import com.autourducode.tourisme.security.services.serviceRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/tourisme/commentaire")

public class ControllerCommentaire {

    @Autowired
    private commentaireServ service;

    @Autowired
    serviceRegion serviceRegion;


    @Autowired
    private RepositoryCommentaire repositoryCommentaire;

    //@PreAuthorize("hasRole('USER')")
    @PostMapping("/ajouter/{id}/{iduser}")
    public String creer(@RequestBody Commentaire commentaire, @PathVariable Long id, @PathVariable Long iduser) {
        region rg = serviceRegion.regionParId(id);

        User us = serviceRegion.userParId(iduser);

            commentaire.setUser(us);
            commentaire.setRegion(rg);
            service.creer(commentaire);
            return "ajouter avec success";

   }

    @GetMapping("/afficher")
    public List<Commentaire> afficher() {
        return service.liste();
    }

    //afficher commentaire par id region
    @GetMapping("/liste/{id}")
    public List<Commentaire> afficherReg(@PathVariable Long id) {
        return repositoryCommentaire.FindCommentaireByRegionId(id);
    }

    @GetMapping("/liste")
    public Iterable<Object[]> listeCommentaire(){
        return service.listeCommentaire();
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/modifier/{id}")
    public Commentaire modifier(@RequestBody Commentaire commentaire, @PathVariable Long id) {
        return service.modifier(commentaire, id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){

        service.supprimer(id);
        return "effacer avec success";
    }
}
