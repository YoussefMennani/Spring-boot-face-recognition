package com.face_recognition.service;

import com.face_recognition.model.Employe;
import com.face_recognition.model.Presence;
import com.face_recognition.repository.EmployeRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        /* date formatter */
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");


        Employe employe = employeRepository.getById(idEmploye);

        List<Presence> presences =  employe.getPresences().stream().filter( (e) ->
                {

                    String dateFromRequest = df.format(dateToCheck).toString();

                    //System.out.println("this is date"+requiredDate);

                    String dateFromDataBase = df.format(e.getDate()).toString();

                    System.out.println("dateFromRequest : "+dateFromRequest);
                    System.out.println("dateFromDataBase : "+dateFromDataBase);


                    return dateFromDataBase.equals(dateFromRequest);
                }
        ).collect(Collectors.toList());


        if(!presences.isEmpty()){
            //System.out.println(presences.get(0).getEmploye().getNom());
            return true;
        }

        return false;
    }
}
