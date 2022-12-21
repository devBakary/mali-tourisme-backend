package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.region;
import com.bezkoder.springjwt.repository.repositoryRegion;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class regionServiceImpl implements serviceRegion{


    @Autowired
    com.bezkoder.springjwt.repository.repositoryRegion repositoryRegion;

    @ApiOperation(value = "Ajout des region")
    @Override
    public region creer(region region) {
        return repositoryRegion.save(region);
    }

    @ApiOperation(value = "liste des regions")
    @Override
    public List<region> afficher() {
        return repositoryRegion.findAll();
    }

    @ApiOperation(value = "Modification dans la region")
    @Override
    public region modifier(Long id, region region) {
        return repositoryRegion.findById(id).
                map(r->{
                    r.setCoderegion(region.getCoderegion());
                    r.setNom(region.getNom());
                    r.setActivite(region.getActivite());
                    r.setLangue(region.getLangue());
                    r.setSuperficie(region.getSuperficie());
                    r.setDescription(region.getDescription());
                    return repositoryRegion.save(r);
                }).orElseThrow(()-> new RuntimeException("region non trouvé !"));
    }

    @ApiOperation(value = "suppression de la population")
    @Override
    public String supprimer(Long id) {
        repositoryRegion.deleteById(id);
        return "region supprimé";
    }
}
