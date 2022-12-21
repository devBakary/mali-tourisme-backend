package com.bezkoder.springjwt.security.services;




import com.bezkoder.springjwt.models.region;

import java.util.List;

public interface serviceRegion {

    region creer(region region);

    List<region> afficher();

    region modifier(Long id, region region);

    String supprimer(Long id);
}
