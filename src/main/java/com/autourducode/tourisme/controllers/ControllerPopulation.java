package com.autourducode.tourisme.controllers;


import com.autourducode.tourisme.models.Population;
import com.autourducode.tourisme.models.region;
import com.autourducode.tourisme.repository.RepositoryPopulation;
import com.autourducode.tourisme.security.services.serviceRegion;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@Data
@RequestMapping("/tourisme/population")
@Api(value = "hello", description = "Mon API de gestion de Tourisme au MAli")
public class ControllerPopulation {

    @Autowired
    private com.autourducode.tourisme.security.services.ServicePopulation ServicePopulation;

    @Autowired
    private serviceRegion serviceRegion;

    @Autowired
    private RepositoryPopulation repositoryPopulation;


    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public Population create(@RequestBody Population population, @PathVariable Long id){

        region rg = serviceRegion.regionParId(id);

        Population p=ServicePopulation.RecupParRgion(rg);
        if(p == null){
            population.setRegion(rg);
            return ServicePopulation.creer(population);
        }
        return null;
    }
    @GetMapping("/liste/{id}")
    public List<Population> trouverTiragesParIdListe(@PathVariable Long id){
        return repositoryPopulation.FindPopulationByRegionId(id);
    }

    @GetMapping("/read")
    public List<Population> read(){
        return ServicePopulation.afficher();
    }

    @GetMapping("/liste")
    public Iterable<Object[]> listeCommentaire(){
        return ServicePopulation.listePop();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id_Population}")
    public Population update(@PathVariable Long id_Population, @RequestBody Population population){
        return ServicePopulation.modifier(id_Population,  population);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id_Population}")
    public String delete(@PathVariable Long id_Population){
        return ServicePopulation.supprimer(id_Population);
    }

}
