package com.face_recognition.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class CheckData {

    private int idEmploye;

    @JsonFormat(pattern="MM/dd/yyyy")
    private Date dateToCheck;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Date getDateToCheck() {
        return dateToCheck;
    }

    public void setDateToCheck(Date dateToCheck) {
        this.dateToCheck = dateToCheck;
    }
}
