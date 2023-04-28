package com.avanade.ad_e_d.dragons.controller;

import com.avanade.ad_e_d.dragons.model.Character;

import com.avanade.ad_e_d.dragons.service.CharacterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/characters")
@Api( value = " DRAGONS API REST")
@CrossOrigin(origins = "*")
public class CharacterController {
    @Autowired
    private CharacterService service;

    @PostMapping("/heroes")
    @ApiOperation("Create a new Hero")
    public ResponseEntity<Character> create(@RequestBody Character character){

        return new ResponseEntity<>(service.create(character), HttpStatus.CREATED );
    }

    @GetMapping("/heroes")
    @ApiOperation("find all heroes  ")
    public ResponseEntity<List<Character>> allHeroes(){

        return new ResponseEntity<>(service.charactersAll(), HttpStatus.OK);
    }

}
