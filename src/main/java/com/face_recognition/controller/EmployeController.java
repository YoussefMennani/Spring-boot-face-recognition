package com.face_recognition.controller;

import com.face_recognition.dto.EmployePresenceDto;
import com.face_recognition.model.Employe;
import com.face_recognition.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeController {

    @Autowired
    EmployeService employeService;

    @GetMapping("/employes")
    public List<EmployePresenceDto> employes(){
        return employeService.getAllEmployes();
    }

    @GetMapping("/employe/{id}")
    public EmployePresenceDto getEmploye(@PathVariable int id){
        return employeService.getEmploye(id);

    }

    @PostMapping("/employe")
    public Employe saveEmploye(@RequestBody Employe employe){

        return employeService.addEmploye(employe);
    }

    /*
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> notFoundException(EntityNotFoundException ex){
        Map<String,String> erreurs = new LinkedHashMap<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println(dtf.format(now));

        erreurs.put("Message","Element not Found");
        erreurs.put("timestamps",dtf.format(now));
        erreurs.put("Status",""+HttpStatus.NOT_FOUND.value());

        return  erreurs;
    }*/



}
