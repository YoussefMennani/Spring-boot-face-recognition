package com.face_recognition.controller;

import com.face_recognition.dto.EmployePresenceDto;
import com.face_recognition.model.Employe;
import com.face_recognition.response.ResponseHandler;
import com.face_recognition.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> employes(){
        List<EmployePresenceDto> employePresenceDtos = employeService.getAllEmployes();
        return ResponseHandler.responseBuilder("Employes got with success",HttpStatus.OK,employePresenceDtos);
    }

    @GetMapping("/employe/{id}")
    public ResponseEntity<Object> getEmploye(@PathVariable int id){
        EmployePresenceDto employePresenceDto = employeService.getEmploye(id);
        return ResponseHandler.responseBuilder("Employe with id : "+id+" got with success",HttpStatus.OK,employePresenceDto);
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
