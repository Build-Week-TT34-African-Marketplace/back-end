package com.lambdaschool.bwafricanmarket.controllers;


import com.lambdaschool.bwafricanmarket.models.Item;
import com.lambdaschool.bwafricanmarket.services.ItemService;
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
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items", produces = {"application/json"})
    public ResponseEntity<?> listAllItems(HttpServletRequest request){
        List<Item> myItems = itemService.findAll();
        return new ResponseEntity<>(myItems, HttpStatus.OK);
    }

    @GetMapping(value = "/item/{itemId}", produces = {"application/json"})
    public ResponseEntity<?> getItemById(HttpServletRequest request, @PathVariable Long itemId){
        Item i = itemService.findItemById(itemId);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping(value = "/item", consumes = "application/json")
    public ResponseEntity<?> addNewItem(@Valid @RequestBody Item newItem) throws URISyntaxException{
        newItem.setItemid(0);
        newItem = itemService.save(newItem);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newItemURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{itemid}").buildAndExpand(newItem.getItemid()).toUri();
        responseHeaders.setLocation(newItemURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/item/{itemId}", consumes = "appliation/json")
    public ResponseEntity<?> updateFullItem(@Valid @RequestBody Item updateItem, @PathVariable long itemid){
        updateItem.setItemid(itemid);
        itemService.save(updateItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable long id){
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
