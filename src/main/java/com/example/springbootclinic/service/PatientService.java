package com.example.springbootclinic.service;

import com.example.springbootclinic.model.Patient;
import com.example.springbootclinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Patient patient){
        patientRepository.insert(patient);
    }


    public void updatePatient(Patient patient){
        Patient savedPatient = patientRepository.findById(patient.getId()).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s", patient.getId())));

        savedPatient.setAddress(patient.getAddress());
        savedPatient.setBirthDay(patient.getBirthDay());
        savedPatient.setLastName(patient.getLastName());
        savedPatient.setName(patient.getName());
        savedPatient.setPhoto(patient.getPhoto());

        patientRepository.save(patient);
    }

    public Patient getPatientById (String patientId){
        return  patientRepository.findById(patientId).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s",patientId)));
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public List<Patient> getPatientsByName(String name){
        return patientRepository.findByName(name);
    }

    public void deletePatient(String id){
        patientRepository.deleteById(id);
    }
}
