package com.example.springbootclinic.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("patient")
public class Patient {

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

    public Patient(String id, String name, String lastName, String birthDay, String address, String photo) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.photo = photo;
    }
}
