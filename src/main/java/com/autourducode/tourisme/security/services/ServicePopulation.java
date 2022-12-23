package com.autourducode.tourisme.security.services;


import com.autourducode.tourisme.models.Population;
import com.autourducode.tourisme.models.region;

import java.util.List;

public interface ServicePopulation {

    Population creer(Population population);

    List<Population> afficher();

    Population modifier(Long id_Population, Population population);

    String supprimer(Long id_Population);

    Iterable<Object[]> listePop();

    Population RecupParRgion(region region);
}
