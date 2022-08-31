package com.face_recognition.service;

import com.face_recognition.dto.PresenceDto;
import com.face_recognition.model.Presence;
import com.face_recognition.repository.PresenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class PresenceService {

    @Autowired
    PresenceRepository presenceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Presence> getAllPressences(){

        return presenceRepository.findAll();
    }

    public Presence savePresence(Presence presence) {

       return presenceRepository.save(presence);
    }

    public PresenceDto getPresence(int id) {
        Presence emp = presenceRepository.getById(id);
        return modelMapper.map(emp,PresenceDto.class);
    }
}
