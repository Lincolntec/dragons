package com.avanade.ad_e_d.dragons.controller;


import com.avanade.ad_e_d.dragons.dto.UserGameDTO;

import com.avanade.ad_e_d.dragons.model.UsersGame;
import com.avanade.ad_e_d.dragons.service.UserGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/users_game")
@Api( value = " Create user game API REST")
@CrossOrigin(origins = "*")
public class UserGameController {

    @Autowired
    private UserGameService service;

    @PostMapping("/start_game")
    @ApiOperation("Start the Game ")
    public ResponseEntity<UsersGame> startTheGame(@RequestBody UserGameDTO usersGame){


        return new ResponseEntity<UsersGame>(service.create(usersGame), HttpStatus.CREATED );
    }

    @GetMapping("/users_game")
    @ApiOperation("find all users  ")
    public ResponseEntity<List<UsersGame>> getUsersGame(){

        return new ResponseEntity<>(service.usersAll(), HttpStatus.OK);
    }



}
