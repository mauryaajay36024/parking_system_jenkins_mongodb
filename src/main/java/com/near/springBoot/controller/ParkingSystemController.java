package com.near.springBoot.controller;
import com.near.springBoot.entity.Vehicle;
import com.near.springBoot.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ParkingSystemController {

  @Autowired
  private DbService dbService;

  //get all vehicle info
  @GetMapping("/vehicles")
  public List<Vehicle> vehicleInfo(){
    return dbService.printInfo();
  }

  //add vehicle info
  @PostMapping("/vehicles")
  public HttpEntity<HttpStatus> addVehicleInfo(@RequestBody Vehicle vehicle){
    try {
      this.dbService.addInfo(vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  //update vehicle info
  @PutMapping("/vehicles/{id}")
  public ResponseEntity<HttpStatus> updateVehicle(@PathVariable String id,@RequestBody Vehicle vehicle){
    try {
      this.dbService.updateInfo(id,vehicle);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  //Delete vehicle info
  @DeleteMapping("/vehicles/{id}")
  public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable String id){
    try {
      this.dbService.deleteInfo(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
