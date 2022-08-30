package com.face_recognition.controller;

import com.face_recognition.service.CheckService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class CheckController {

    @Autowired
    CheckService checkService;

    @GetMapping("/check")
    public boolean checkIfPresent(@RequestParam int idEmploye, @RequestParam Date dateToCheck){
        
        return checkService.check(idEmploye,dateToCheck);
        //System.out.println(" id "+idEmploye+" date is : "+dateToCheck);
    }
}
