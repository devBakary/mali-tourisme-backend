package com.autourducode.tourisme.controllers;


import com.autourducode.tourisme.models.Commentaire;
import com.autourducode.tourisme.models.region;
import com.autourducode.tourisme.repository.repositoryRegion;
import com.autourducode.tourisme.security.services.commentaireServ;
import com.autourducode.tourisme.security.services.serviceRegion;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/tourisme/commentaire")

public class ControllerCommentaire {

    @Autowired
    private commentaireServ service;

    @Autowired
    serviceRegion serviceRegion;

    //@PreAuthorize("hasRole('USER')")
    @PostMapping("/ajouter/{id}")
    public String creer(@RequestBody Commentaire commentaire, @PathVariable Long id) {
        region rg = serviceRegion.regionParId(id);

            commentaire.setRegion(rg);
            service.creer(commentaire);
            return "ajouter avec success";

   }

    @GetMapping("/afficher")
    public List<Commentaire> afficher() {
        return service.liste();
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
