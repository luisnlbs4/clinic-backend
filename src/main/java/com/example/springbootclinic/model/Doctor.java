package com.example.springbootclinic.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Doctor {

    @Id
    private String id;

    @NonNull
    @Field(name="name")
    private String name;

    @NonNull
    @Field(name="lastName")
    private String lastName;

    @NonNull
    @Field(name="birthDay")
    private String birthDay;

    @NonNull
    @Field(name="specialty")
    private String specialty;

    @NonNull
    @Field(name="address")
    private String address;

    @Field(name="photo")
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Doctor(String id, String name, String lastName, String birthDay, String specialty, String address, String photo) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.specialty = specialty;
        this.address = address;
        this.photo = photo;
    }
}
