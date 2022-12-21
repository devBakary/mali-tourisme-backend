package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryRegion extends JpaRepository<region, Long> {

   /* @Query(value = "SELECT code_region, domaine_activite, langue_parler, nom_region, superficie," +
            " habitants, annee FROM region, population WHERE region.id_region = population.region_id_region",
            nativeQuery = true)
    Iterable<Object[]> regionSansPays();

    @Query(value = "SELECT region.code_region, region.domaine_activite, region.langue_parler, region.nom_region, region.superficie, population.habitants," +
            " population.annee, pays.nom FROM region, population, pays WHERE region.id_region = population.region_id_region" +
            " AND region.pays_id = pays.id", nativeQuery = true)
    Iterable<Object[]> mesRegions();*/


}
