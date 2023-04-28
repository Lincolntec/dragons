package com.avanade.ad_e_d.dragons.controller;

import com.avanade.ad_e_d.dragons.dto.StartTheGame;
import com.avanade.ad_e_d.dragons.model.UsersGame;
import com.avanade.ad_e_d.dragons.service.BattleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/games")
@Api( value = " DRAGONS API REST")
@CrossOrigin(origins = "*")
public class BattleController {

    @Autowired
    private BattleService service;

    @PostMapping("/start_game")
    @ApiOperation("Start the Game ")
    public ResponseEntity<StartTheGame> startTheGame(@RequestBody List<Long> users){

        return new ResponseEntity<>(service.initiative(users), HttpStatus.CREATED );
    }

    @PostMapping("/start_game/attack")
    @ApiOperation("ataque")
    public ResponseEntity<Double> ataque(@RequestBody UsersGame usersGame){

        return new ResponseEntity<>( service.attack(usersGame), HttpStatus.OK);
    }

    @PostMapping("/start_game/defense")
    @ApiOperation("defense")
    public ResponseEntity<Double> defense(@RequestBody UsersGame usersGame){

        return new ResponseEntity<>( service.defense(usersGame), HttpStatus.OK);
    }

}
