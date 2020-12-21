package org.masiv.rouletteApi.controllers;
import org.masiv.rouletteApi.exceptions.RouletteServicesException;
import org.masiv.rouletteApi.model.Bet;
import org.masiv.rouletteApi.model.User;
import org.masiv.rouletteApi.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/masivRoulette")
public class RouletteController {
    @Autowired
    private RouletteServices services;
    @PostMapping
    public ResponseEntity<?> createRoulette(){
        String rouletteId = services.createRoulette();

        return new ResponseEntity<>(rouletteId, HttpStatus.CREATED);
    }
    @PatchMapping("roulette/{id}/open")
    public ResponseEntity<?> openRouletteById(@PathVariable String id){
        try {
            services.openRouletteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RouletteServicesException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("roulette/{id}/bet")
    public ResponseEntity<?> addBetById(@PathVariable String id, @RequestBody Bet bet, @RequestHeader("user-id") String userId){
        try{
            services.addBetById(id, bet, new User(userId));

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RouletteServicesException e){

            return  new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @PatchMapping("roulette/{id}/close")
    public ResponseEntity<?> closeBetById(@PathVariable String id){
        try{

            return new ResponseEntity<>(services.closeRouletteById(id), HttpStatus.OK);
        }catch (RouletteServicesException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllRoulettes(){

        return new ResponseEntity<>(services.getAllRoulettes(), HttpStatus.OK);
    }
}
