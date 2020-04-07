package com.james.wagstaff.polymorphism.entities.warehouse.products;

import com.james.wagstaff.polymorphism.entities.AWarehouseItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Bed extends AWarehouseItem {

    private double widthInMeters;
    private double lengthInMeters;

}
