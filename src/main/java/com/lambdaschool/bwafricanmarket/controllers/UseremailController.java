package com.lambdaschool.bwafricanmarket.controllers;

import com.lambdaschool.bwafricanmarket.models.Useremail;
import com.lambdaschool.bwafricanmarket.services.UseremailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/useremails")
public class UseremailController {
    @Autowired
    UseremailService useremailService;

    @GetMapping(value = "/useremails",
            produces = "application/json")
    public ResponseEntity<?> listAllUseremails(){
        List<Useremail> allUserEmails = useremailService.findAll();
        return new ResponseEntity<>(allUserEmails, HttpStatus.OK);
    }

    @GetMapping(value = "/useremail/{useremailId}", produces = "application/json")
    public ResponseEntity<?> getUserEmailById(@PathVariable Long useremailId){
        Useremail ue = useremailService.findUseremailById(useremailId);
        return new ResponseEntity<>(ue, HttpStatus.OK);
    }
}
