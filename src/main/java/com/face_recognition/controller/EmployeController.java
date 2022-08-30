package com.face_recognition.controller;

import com.face_recognition.dto.EmployePresenceDto;
import com.face_recognition.model.Employe;
import com.face_recognition.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeController {

    @Autowired
    EmployeService employeService;

    @GetMapping("/employes")
    public List<EmployePresenceDto> employes(){
        return employeService.getAllEmployes();
    }

    @PostMapping("/employe")
    public Employe saveEmploye(@RequestBody Employe employe){

        return employeService.addEmploye(employe);
    }

}
