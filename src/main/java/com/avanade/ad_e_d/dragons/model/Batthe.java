package com.avanade.ad_e_d.dragons.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BATTLHE")
public class Batthe implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long battleId;

    private UsersGame usersGame;

    private Character character;

    private LocalDateTime createdAt;

    private Turn turn;

    private String result;


    }
