package com.example.springbootclinic.controller;

import com.example.springbootclinic.model.Consult;
import com.example.springbootclinic.model.Patient;
import com.example.springbootclinic.service.ConsultService;
import com.example.springbootclinic.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/consult")

public class ConsultController {

    private final ConsultService consultService;


    public ConsultController(ConsultService consultService) {
        this.consultService = consultService;
    }

    @PostMapping
    public ResponseEntity addConsult(@RequestBody Consult consult){
        consultService.addConsult(consult);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Consult>> getAllConsults(){
        return ResponseEntity.ok(consultService.getAllConsults());
    }

    @PutMapping
    public ResponseEntity<Object> updateConsult(@RequestBody Consult consult){
        consultService.updateConsult(consult);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{consultId}")
    public ResponseEntity<Consult> getConsultsById(@PathVariable String consultId){
        return ResponseEntity.ok(consultService.getConsultById(consultId));
    }
    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<List<Optional<Patient>>> getConsultsByDoctorId(@PathVariable String doctorId){
        return ResponseEntity.ok(consultService.getConsultByDoctorId(doctorId));
    }

    @GetMapping("patient/{patientId}")
    public ResponseEntity<List<Consult>> getConsultsByPatientId(@PathVariable String patientId){
        return ResponseEntity.ok(consultService.getConsultByPatientId(patientId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteConsult(@PathVariable String id){
        consultService.deleteConsult(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
