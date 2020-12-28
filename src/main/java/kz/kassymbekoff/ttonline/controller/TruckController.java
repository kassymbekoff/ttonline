package kz.kassymbekoff.ttonline.controller;

import kz.kassymbekoff.ttonline.exception.ResourceNotFoundException;
import kz.kassymbekoff.ttonline.model.Truck;
import kz.kassymbekoff.ttonline.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Бекарыс on 23.12.2020
 */

@RestController
public class TruckController {

    @Autowired
    TruckService truckService;

    @GetMapping("/trucks")
    public ResponseEntity<Map<String, Object>> getTrucks(){
        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("trucks", truckService.findAll());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/trucks/{id}")
    public ResponseEntity<Map<String, Object>> getTruck(@PathVariable(value = "id") Long id){
        Map<String, Object> result = new HashMap<>();
        Truck truck = truckService.findById(id);
        result.put("status", HttpStatus.OK.value());
        if(truck == null){
            throw new ResourceNotFoundException("Truck not found " + id);
        }
        result.put("truck", truck);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/trucks")
    public ResponseEntity<Map<String, Object>> addTruck(@RequestBody Truck truck){
        Map<String, Object> result = new HashMap<>();
        Truck createdTruck = truckService.save(truck);

        result.put("status", HttpStatus.CREATED.value());
        result.put("truck", createdTruck);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/trucks/{id}")
    public ResponseEntity<Map<String, Object>> updateTruck(@PathVariable(value = "id") Long id,
                                                           @RequestBody Truck truck){
        Map<String, Object> result = new HashMap<>();
        Truck updatedTruck = truckService.update(id, truck);
        if(updatedTruck == null){
            throw new ResourceNotFoundException("Truck not found " + id);
        }
        result.put("status", HttpStatus.OK.value());
        result.put("truck", updatedTruck);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/trucks/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable(value = "id") Long id){
        Map<String, Object> result = new HashMap<>();
        truckService.deleteById(id);
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/trucks")
    public ResponseEntity<Map<String, Object>> deleteAll(){
        Map<String, Object> result = new HashMap<>();
        truckService.deleteAll();
        result.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(result);
    }




}
