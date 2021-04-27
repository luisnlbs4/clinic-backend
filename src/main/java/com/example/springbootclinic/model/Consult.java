package com.example.springbootclinic.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Consult {

    @Id
    private String id;

    @NonNull
    @Field(name="doctorId")
    private String doctorId;

    @NonNull
    @Field(name="patientId")
    private String patientId;

    @NonNull
    @Field(name="description")
    private String description;

    @NonNull
    @Field(name="date")
    private String date;

    @NonNull
    @Field(name="prescription")
    private String prescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Consult(String id, String doctorId, String patientId, String description, String date, String prescription) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.description = description;
        this.date = date;
        this.prescription = prescription;
    }


}
