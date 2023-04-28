package com.avanade.ad_e_d.dragons.service;

import com.avanade.ad_e_d.dragons.model.Character;
import com.avanade.ad_e_d.dragons.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repository;
    public Character create(Character character){

       return this.repository.save(character);

    }
    public Character getCharacter(Long id){

        return this.repository.findById(id).get();

    }

    public List<Character> charactersAll(){

        return this.repository.findAll();
    }

    public void delete(Long id){

        this.repository.deleteById(id);

    }

    public Character update(Character character){
        return this.repository.save(character);
    }

}
