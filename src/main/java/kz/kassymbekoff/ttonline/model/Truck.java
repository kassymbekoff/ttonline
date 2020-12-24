package kz.kassymbekoff.ttonline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Бекарыс on 23.12.2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trucks")
public class Truck implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Float price;
    private String comment;
}
