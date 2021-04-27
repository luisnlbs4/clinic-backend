package com.example.springbootclinic.service;

import com.example.springbootclinic.model.Doctor;
import com.example.springbootclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;


    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.insert(doctor);
    }


    public void updateDoctor(Doctor doctor){
        Doctor savedDoctor = doctorRepository.findById(doctor.getId()).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s", doctor.getId())));

        savedDoctor.setAddress(doctor.getAddress());
        savedDoctor.setBirthDay(doctor.getBirthDay());
        savedDoctor.setLastName(doctor.getLastName());
        savedDoctor.setName(doctor.getName());
        savedDoctor.setSpecialty(doctor.getSpecialty());
        savedDoctor.setPhoto(doctor.getPhoto());

        doctorRepository.save(doctor);
    }

    public Doctor getDoctorById (String doctorId){
        return  doctorRepository.findById(doctorId).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by ID %s",doctorId)));
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }


    public Doctor getDoctorByName(String name){
      return doctorRepository.findByName(name).orElseThrow(()-> new RuntimeException(
                String.format("Cannot find Expense by Name %s", name)));
    }

    public void deleteDoctor(String id){
        doctorRepository.deleteById(id);
    }
}
