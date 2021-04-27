package com.example.springbootclinic.repository;

import com.example.springbootclinic.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository <Doctor,String>{

    @Query ("{ $or: [ {'name' : {$regex: ?0} }, {'lastName' : {$regex: ?0}} ]}")
    Optional<Doctor> findByName(String name);
}
