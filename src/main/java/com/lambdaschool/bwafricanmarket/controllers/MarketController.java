package com.lambdaschool.bwafricanmarket.controllers;


import com.lambdaschool.bwafricanmarket.models.Market;
import com.lambdaschool.bwafricanmarket.services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {
    @Autowired
    MarketService marketService;

    @GetMapping(value = "/market", produces = {"application/json"})
    public ResponseEntity<?> listAllMarkets(HttpServletRequest request){
        List<Market> myMarkets = marketService.findAll();
        return new ResponseEntity<>(myMarkets, HttpStatus.OK);
    }
    @GetMapping(value = "/market/{marketId}", produces = {"application/json"})
    public ResponseEntity<?> getMarketById(HttpServletRequest request, @PathVariable Long marketId){
        Market m = marketService.findMarketById(marketId);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping(value = "/market/{marketLocation}", produces = {"application/json"})
    public ResponseEntity<?> getMarketByLocation(HttpServletRequest request, @PathVariable Long marketLocation){
        Market m = marketService.findMarketByLocation(marketLocation);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @PostMapping(value = "/market", consumes = "application/json")
    public ResponseEntity<?> addNewMarket(@Valid @RequestBody Market newMarket) throws URISyntaxException{
        newMarket.setMarketid(0);
        newMarket = marketService.save(newMarket);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMarketURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{marketid}").buildAndExpand(newMarket.getMarketid()).toUri();
        responseHeaders.setLocation(newMarketURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/market/{marketid}", consumes = "application/json")
    public ResponseEntity<?> updateFullBook(@Valid @RequestBody Market updateMarket, @PathVariable long marketid){
        updateMarket.setMarketid(marketid);
        marketService.save(updateMarket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/market/{id}")
    public ResponseEntity<?> deleteMarketById(@PathVariable long id){
        marketService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
