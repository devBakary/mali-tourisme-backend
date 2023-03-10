package com.autourducode.tourisme.repository;


import com.autourducode.tourisme.models.Population;
import com.autourducode.tourisme.models.region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPopulation extends JpaRepository<Population, Long> {

    @Query(value = "select population.annee, population.habitants, region.nom, region.coderegion, region.superficie, " +
            "region.activite, region.langue, region.id from population, region where population.region_id = region.id", nativeQuery = true)
    Iterable<Object[]> listePop();

    Population findByRegion(region region);

    @Query(value="select * from population where region_id = ?", nativeQuery = true)
    public List<Population> FindPopulationByRegionId(Long id);
}
