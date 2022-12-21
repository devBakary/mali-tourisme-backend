package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.region;
import com.bezkoder.springjwt.security.services.serviceRegion;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/tourisme/region")
@Data
@Api(value = "hello", description = "Mon API de gestion de site de Tourisme au Mali")
public class controllerRegion {

    @Autowired
    com.bezkoder.springjwt.security.services.serviceRegion serviceRegion;




    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public region create(@RequestBody region region){
        return serviceRegion.creer(region);
    }


    @GetMapping("/read")
    public List<region> read(){
        return serviceRegion.afficher();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public region update(@PathVariable Long id, @RequestBody region region){
        return serviceRegion.modifier(id,  region);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return serviceRegion.supprimer(id);
    }

}
