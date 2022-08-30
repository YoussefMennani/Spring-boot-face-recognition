package com.face_recognition.service;

import com.face_recognition.model.Presence;
import com.face_recognition.repository.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class PresenceService {

    @Autowired
    PresenceRepository presenceRepository;

    public List<Presence> getAllPressences(){

        return presenceRepository.findAll();
    }

    public Presence savePresence(Presence presence) {

       return presenceRepository.save(presence);
    }
}
