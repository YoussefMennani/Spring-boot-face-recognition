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
    public String checkIfPresent(@RequestParam int idEmploye, @RequestParam Date dateToCheck) {

        Boolean testPesence = checkService.check(idEmploye, dateToCheck);

        if (testPesence == true) {
            return "Employe present ";
        } else {
            return "Employe Abscent ";
        }
        //System.out.println(" id "+idEmploye+" date is : "+dateToCheck);

    }

}
