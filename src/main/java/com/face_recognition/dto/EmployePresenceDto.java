package com.face_recognition.dto;

import com.face_recognition.model.Presence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployePresenceDto {

    private int id;

    private String nom;


    private List<Presence> presences;


}
