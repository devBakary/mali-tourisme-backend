package com.autourducode.tourisme.security.services;


import com.autourducode.tourisme.models.User;
import com.autourducode.tourisme.models.region;
import com.autourducode.tourisme.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class regionServiceImpl implements serviceRegion{


    @Autowired
    private UserRepository userRepository;
    @Autowired
    com.autourducode.tourisme.repository.repositoryRegion repositoryRegion;

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

        @Override
        public Optional<region> regionById(Long id) {
            return repositoryRegion.findById(id);
        }

    @Override
    public region regionParId(Long id) {
        return repositoryRegion.findById(id).get();
    }

    @ApiOperation(value = "suppression de la population")
    @Override
    public String supprimer(Long id) {
        repositoryRegion.deleteById(id);
        return "region supprimé";
    }

    @Override
    public User userParId(Long id) {
        return userRepository.findById(id).get();
    }
}
