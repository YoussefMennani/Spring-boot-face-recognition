package com.face_recognition.config;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PresenceDto {

    private int id;

    @JsonFormat(pattern="MM/dd/yyyy")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
