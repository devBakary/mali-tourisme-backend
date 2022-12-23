package com.autourducode.tourisme.controllers;



import com.autourducode.tourisme.models.region;
import com.autourducode.tourisme.repository.repositoryRegion;
import com.autourducode.tourisme.security.FileUploadUtil;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/tourisme/region")
@Data
public class controllerRegion {

    @Autowired
    com.autourducode.tourisme.security.services.serviceRegion serviceRegion;

    @Autowired
    private repositoryRegion repositoryRegion;




    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public region create(@RequestBody region region){
        return serviceRegion.creer(region);
    }


    @GetMapping("/read")
    public List<region> read(){
        return serviceRegion.afficher();
    }

    ///@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public region update(@PathVariable Long id, @RequestBody region region){
        return serviceRegion.modifier(id,  region);
    }

    @GetMapping("/get/{id}")
    public Optional<region> regionById(@PathVariable Long id) {
        return serviceRegion.regionById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return serviceRegion.supprimer(id);
    }

    @PostMapping("/ajout")
    public String handleFormSubmit(
                                @Param("activite") String activite,
                                @Param("coderegion") String coderegion,
                                @Param("description") String description,
                                @Param("img") MultipartFile img,
                                @Param("langue") String langue,
                                @Param("nom") String nom,
                                @Param("superficie") String superficie

                                  ) throws IOException {

        String imge = StringUtils.cleanPath(img.getOriginalFilename());
        region region = new region();

System.out.println(imge);
        region.setActivite(activite);
        region.setCoderegion(coderegion);
        region.setDescription(description);
        region.setImg(imge);
        region.setLangue(langue);
        region.setNom(nom);
        region.setSuperficie(superficie);

        region savedCandidate = repositoryRegion.save(region);
        String uploadDir = "C:\\Users\\bddiakite\\Desktop\\MaliTourisme-Front\\src\\assets\\mesimages";

        FileUploadUtil.saveFile(uploadDir, imge, img);

        return "message";
    }

}
