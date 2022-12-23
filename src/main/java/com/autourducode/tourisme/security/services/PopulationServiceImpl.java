package com.autourducode.tourisme.security.services;


import com.autourducode.tourisme.models.Population;
import com.autourducode.tourisme.models.region;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements ServicePopulation {

    @Autowired
    private com.autourducode.tourisme.repository.RepositoryPopulation RepositoryPopulation;

    @Override
    public Population creer(Population population) {
        return RepositoryPopulation.save(population);
    }

    @Override
    public List<Population> afficher() {
        return RepositoryPopulation.findAll();
    }


    @Override
    public Population modifier(Long id_Population, Population population) {
        return   RepositoryPopulation.findById(id_Population).
                map(pp->{
                    pp.setId(population.getId());
                    pp.setAnnee(population.getAnnee());
                    pp.setHabitants(population.getHabitants());
                    return RepositoryPopulation.save(pp);
                }).orElseThrow(()-> new RuntimeException("pas de population trouvé !"));
    }

    @Override
    public String supprimer(Long id_Population) {
        RepositoryPopulation.deleteById(id_Population);
        return "population supprimé";
    }

    @Override
    public Iterable<Object[]> listePop() {
        return RepositoryPopulation.listePop();
    }

    @Override
    public Population RecupParRgion(region region) {
        return RepositoryPopulation.findByRegion(region);
    }
}
