package com.near.springBoot.services;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MongolClient implements DbService {

  @Autowired
  private MongoRepository<Vehicle, String> mongoRepository;

  @Override
  public List<Vehicle> printInfo() {
    return mongoRepository.findAll();
  }

  @Override
  public Vehicle addInfo(Vehicle vehicle) {
    mongoRepository.save(vehicle);
    return vehicle;
  }

  @Override
  public Vehicle updateInfo(String  id,Vehicle vehicleDetails) throws ResourceNotFoundException{
   Vehicle vehicle = mongoRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found !!!"));

    vehicle.setRegNo(vehicleDetails.getRegNo());
   vehicle.setColour(vehicleDetails.getColour());
   Vehicle updatedVehicle= (Vehicle) mongoRepository.save(vehicle);
   return updatedVehicle;

  }

  @Override
  public Map<String, Boolean> deleteInfo(String id) throws ResourceNotFoundException{
    Vehicle vehicle=mongoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found !!!"));
    mongoRepository.delete(vehicle);
    Map<String,Boolean> response=new HashMap<>();
    response.put("Deleted",Boolean.TRUE);
    return response;


  }


}
