package com.example.springbootclinic.controller;

import com.example.springbootclinic.model.Doctor;
import com.example.springbootclinic.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor")

public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PutMapping
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor doctor){
        doctorService.updateDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String doctorId){
        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Doctor> getDoctorsByName(@PathVariable String name){
        return ResponseEntity.ok(doctorService.getDoctorByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteConsult(@PathVariable String id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
