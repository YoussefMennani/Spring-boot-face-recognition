package com.face_recognition.service;

import com.face_recognition.dto.EmployePresenceDto;
import com.face_recognition.exception.EmployeNotFoundException;
import com.face_recognition.model.Employe;
import com.face_recognition.repository.EmployeRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeService {

    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<EmployePresenceDto> getAllEmployes(){

        List<Employe> employes =  employeRepository.findAll();
        List<EmployePresenceDto> employePresenceDto= new ArrayList<>();

        for (Employe employe :employes) {

            EmployePresenceDto newEmploye =  modelMapper.map(employe,EmployePresenceDto.class);
            //System.out.println(newEmploye.getName());
            employePresenceDto.add(newEmploye);
        }

        return employePresenceDto;

    }

    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public EmployePresenceDto getEmploye(int id) {

        if(!employeRepository.findById(id).isEmpty()) {
            return modelMapper.map(employeRepository.getById(id), EmployePresenceDto.class);
        }else{
            throw new EmployeNotFoundException(" Employe with ID :"+id+" Not Existe !");
        }


    }
}
