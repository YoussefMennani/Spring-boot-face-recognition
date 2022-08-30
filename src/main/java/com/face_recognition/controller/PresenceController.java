package com.face_recognition.controller;

import com.face_recognition.model.Employe;
import com.face_recognition.model.Presence;
import com.face_recognition.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PresenceController {

    @Autowired
    PresenceService presenceService;

    @GetMapping("/presences")
    public List<Presence> presences(){
        return  presenceService.getAllPressences();
    }

    @PostMapping("/presence/{id}")
    public Presence savePresence(@RequestBody Presence presence, @PathVariable int id){

        Employe e = new Employe();
        e.setId(id);
        presence.setEmploye(e);
        System.out.println(presence.getEmploye());


        return  presenceService.savePresence(presence);
    }
}
