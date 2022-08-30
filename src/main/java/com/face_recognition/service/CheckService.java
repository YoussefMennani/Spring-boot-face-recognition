package com.face_recognition.service;

import com.face_recognition.model.Employe;
import com.face_recognition.model.Presence;
import com.face_recognition.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckService {

    @Autowired
    EmployeRepository employeRepository;


    public boolean check(int idEmploye, Date dateToCheck) {


        Employe employe = employeRepository.getById(idEmploye);

        List<Presence> presences =  employe.getPresences().stream().filter(e -> e.getDate().equals(dateToCheck)).collect(Collectors.toList());
        System.out.println(dateToCheck);

        if(!presences.isEmpty()){

            System.out.println(presences.get(0).getEmploye().getNom());
            return true;
        }

        return false;
    }
}
