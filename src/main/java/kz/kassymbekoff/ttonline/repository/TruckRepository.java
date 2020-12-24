package kz.kassymbekoff.ttonline.repository;

import kz.kassymbekoff.ttonline.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Бекарыс on 23.12.2020
 */
public interface TruckRepository extends JpaRepository<Truck, Long> {
}
