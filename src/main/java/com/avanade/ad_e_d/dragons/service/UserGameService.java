package com.avanade.ad_e_d.dragons.service;

import com.avanade.ad_e_d.dragons.dto.UserGameDTO;
import com.avanade.ad_e_d.dragons.model.Character;
import com.avanade.ad_e_d.dragons.model.UsersGame;
import com.avanade.ad_e_d.dragons.repository.CharacterRepository;
import com.avanade.ad_e_d.dragons.repository.UsersGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGameService {

    @Autowired
    private UsersGameRepository repository;

    @Autowired
    private CharacterRepository characterRepository;

    public UsersGame create(UserGameDTO user){

        Optional<Character> character =  characterRepository.findById(user.getCharacterId());

        UsersGame usersGame = new UsersGame();

        usersGame.setName(user.getName());
        usersGame.setCharacter(character.get());
       // user.setCharacter(idCharacter);

        return this.repository.save(usersGame);
    }

    public List<UsersGame> usersAll(){

       return repository.findAll();

    }
}
