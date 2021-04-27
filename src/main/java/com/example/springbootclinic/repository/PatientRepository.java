package com.example.springbootclinic.repository;

import com.example.springbootclinic.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends MongoRepository <Patient,String>{

//    @Query ("{'name' : {$regex: ?0} }")
    @Query ("{ $or: [ {'name' : {$regex: ?0} }, {'lastName' : {$regex: ?0}} ]}")
    List<Patient> findByName (String name);
}
