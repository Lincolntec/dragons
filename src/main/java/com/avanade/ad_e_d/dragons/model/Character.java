package com.avanade.ad_e_d.dragons.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CHARACTER")
public class Character implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long characterId;
    private String hero;

    private Long life;

    private Double strength;

    private Double defense;

    private Double agility;

    private int amountOfData;

    private int diciesFaces;

}
