package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String coderegion;
    @Column(unique = true)
    private String nom;

    private String activite;

    private String langue;
    private String superficie;
    private String description;


    /*@ManyToOne
    private pays pays;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<Population> population;*/



}
