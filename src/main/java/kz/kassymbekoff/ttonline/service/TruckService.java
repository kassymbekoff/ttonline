package kz.kassymbekoff.ttonline.service;

import kz.kassymbekoff.ttonline.model.Truck;
import kz.kassymbekoff.ttonline.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Бекарыс on 23.12.2020
 */
@Service
public class TruckService {

    @Autowired
    TruckRepository truckRepository;

    public List<Truck> findAll(){
        return truckRepository.findAll();
    }

    public Truck findById(Long id){
        return truckRepository.findById(id).orElse(null);
    }

    public Truck save(Truck truck){
        return truckRepository.save(truck);
    }

    public Truck update(Long id, Truck truck){
        Optional<Truck> oldTruck = truckRepository.findById(id);
        if(!oldTruck.isPresent()) {
            return null;
        }
        oldTruck.get().setName(truck.getName());
        oldTruck.get().setComment(truck.getComment());
        oldTruck.get().setPrice(truck.getPrice());
        return truckRepository.save(oldTruck.get());
    }

    public void deleteById(Long id){
        truckRepository.deleteById(id);
    }

    public void deleteAll(){
        truckRepository.deleteAll();
    }
}
