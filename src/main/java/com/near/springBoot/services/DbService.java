package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;


public interface DbService {
  List<Vehicle> printInfo();

  Vehicle addInfo(Vehicle vehicle);

  Vehicle updateInfo(String  id,Vehicle vehicle) throws ResourceNotFoundException;

  Map<String,Boolean> deleteInfo(String id) throws ResourceNotFoundException;
}
