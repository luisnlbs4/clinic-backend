package com.example.springbootclinic.service;

import com.example.springbootclinic.model.Consult;
import com.example.springbootclinic.model.Patient;
import com.example.springbootclinic.repository.ConsultRepository;
import com.example.springbootclinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultService {

    private final ConsultRepository consultRepository;
    private final PatientRepository patientRepository;


    public ConsultService(ConsultRepository consultRepository, PatientRepository patientRepository) {
        this.consultRepository = consultRepository;
        this.patientRepository = patientRepository;
    }

    public void addConsult(Consult consult){
        consultRepository.insert(consult);
    }


    public void updateConsult(Consult consult){
        Consult saveConsult = consultRepository.findById(consult.getId()).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s", consult.getId())));


        saveConsult.setDate(consult.getDate());
        saveConsult.setDescription(consult.getDescription());
        saveConsult.setDoctorId(consult.getDoctorId());
        saveConsult.setPatientId(consult.getPatientId());
        saveConsult.setPrescription(consult.getPrescription());

        consultRepository.save(consult);
    }


    public List<Consult> getAllConsults(){
        return consultRepository.findAll();
    }


    public List<Optional<Patient>> getConsultByDoctorId(String doctorId){

        List<Consult> listConsult = consultRepository.findByDoctorId(doctorId);
        List<Optional<Patient>> listPatients = new ArrayList();
        for (Consult consult : listConsult) {
            listPatients.add(patientRepository.findById(consult.getPatientId()));
        }
      return listPatients;
    }

    public Consult getConsultById (String consultId){
        return  consultRepository.findById(consultId).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s",consultId)));
    }

    public List<Consult> getConsultByPatientId(String patientId){
        return consultRepository.findByPatientId(patientId);
    }

    public void deleteConsult(String id){
        consultRepository.deleteById(id);
    }
}
