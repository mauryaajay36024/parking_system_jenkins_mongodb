package com.near.springBoot.repository;

import com.near.springBoot.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongodbRepository extends MongoRepository<Vehicle,String> {

}
