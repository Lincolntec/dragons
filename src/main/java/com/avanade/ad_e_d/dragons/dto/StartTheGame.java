package com.avanade.ad_e_d.dragons.dto;

import com.avanade.ad_e_d.dragons.model.UsersGame;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
public class StartTheGame implements Serializable {

    @Autowired
    private UsersGame usersGame;

    private double value;

    private final String  wins = "You started the game!! ";
}
