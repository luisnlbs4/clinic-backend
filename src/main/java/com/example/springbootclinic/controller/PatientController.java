package com.example.springbootclinic.controller;

import com.example.springbootclinic.model.Patient;
import com.example.springbootclinic.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")

public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping
    public ResponseEntity<Object> updatePatient(@RequestBody Patient patient){
        patientService.updatePatient(patient);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String patientId){
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Patient>> getPatientByName(@PathVariable String name){
        return ResponseEntity.ok(patientService.getPatientsByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
