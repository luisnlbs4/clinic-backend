package com.example.springbootclinic.repository;

import com.example.springbootclinic.model.Consult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConsultRepository extends MongoRepository <Consult,String>{

    @Query("{'doctorId' : ?0 }")
    List<Consult> findByDoctorId(String id);


    @Query("{'patientId' : ?0 }")
    List<Consult> findByPatientId(String id);
}
