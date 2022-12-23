package com.autourducode.tourisme.security.services;




import com.autourducode.tourisme.models.region;

import java.util.List;
import java.util.Optional;

public interface serviceRegion {

    region creer(region region);

    List<region> afficher();

    region modifier(Long id, region region);

    Optional<region> regionById(Long id);

    region regionParId(Long id);

    String supprimer(Long id);
}
