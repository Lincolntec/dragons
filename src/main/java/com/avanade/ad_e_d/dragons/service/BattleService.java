package com.avanade.ad_e_d.dragons.service;


import com.avanade.ad_e_d.dragons.dto.StartTheGame;
import com.avanade.ad_e_d.dragons.model.Character;
import com.avanade.ad_e_d.dragons.model.Round;
import com.avanade.ad_e_d.dragons.model.UsersGame;
import com.avanade.ad_e_d.dragons.repository.BattheRepository;
import com.avanade.ad_e_d.dragons.repository.RoundRepository;
import com.avanade.ad_e_d.dragons.repository.UsersGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattleService {

    int min_val = 1;
    int max_val = 20;

    double playerOne;

    double playerTwo;

    Long defender = 0l;
    Long aggressor = 0l;


    @Autowired
    private BattheRepository repository;

    private RoundRepository roundRepository;

    @Autowired
    private UsersGameRepository usersGameRepository;


    private StartTheGame startTheGame = new StartTheGame();

    Character characterDefender = new Character();

    Character characterAggressor = new Character();


    public StartTheGame initiative(List<Long> usersId){

        return checkWhoWon(usersId);
    }

    public Double attack(UsersGame usersGame){

       return  attackRound(usersGame.getCharacter());
    }

    public Double defense( UsersGame usersGame){
        return defenseRound(usersGame.getCharacter());
    }

    public Round chooseThePlayer(Round round){

        return roundRepository.save(round);

    }

    private Double defenseRound(Character character){
        var dado = Math.random() * ( max_val - min_val );
        var defence = (dado + character.getDefense() + character.getAgility());

        return defence;
    }

    private Double damage(Character character){

        var dado = Math.random() * ( character.getDiciesFaces() - character.getAmountOfData()  );

        return dado;
    }

    private Double attackRound(Character character){

        var dado = Math.random() * ( max_val - min_val );
        var forcaGolpe =  (dado + character.getDefense() + character.getAgility());

        return forcaGolpe;
    }


    private Character getCharacter(Long user) {
        Optional<UsersGame> usersGame = findByUser(user);

        Character character = usersGame.get().getCharacter();
        return character;
    }


    private Optional<UsersGame> findByUser(Long userId){
        return  usersGameRepository.findById(userId);
    }
    private StartTheGame checkWhoWon(List<Long> users) {


        playerOne = Math.random() * ( max_val - min_val );

        playerTwo = Math.random() * ( max_val - min_val );

        if( playerOne > playerTwo ){

            new StartTheGame();
            var one = usersGameRepository.findById(users.get(0).longValue());

            if(one.isPresent()){
                UsersGame userOne = one.get();
                startTheGame.setUsersGame(userOne);
            }

            startTheGame.setValue(playerOne);

            return startTheGame;
        }

        if( playerOne < playerTwo ){

            var tow = usersGameRepository.findById(users.get(1).longValue());

            if(tow.isPresent()){
                UsersGame userTow = tow.get();
                startTheGame.setUsersGame(userTow);
            }
        }

       startTheGame.setValue(playerTwo);

        return  startTheGame;

    }


}
