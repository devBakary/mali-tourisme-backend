package com.autourducode.tourisme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coderegion;
    private String langue;
    @Column(unique = true)
    private String nom;

    private String activite;


    private String superficie;
    private String description;

    @Column(name = "profile_picture")
    private String img;




    /*@ManyToOne
    private pays pays;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<Population> population;*/



}
