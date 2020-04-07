package com.james.wagstaff.polymorphism.entities.warehouse.products;

import com.james.wagstaff.polymorphism.entities.AWarehouseItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Computer extends AWarehouseItem {

    private String cpu;
    private Short coreCount;
    private Short ram;
    private Short hdCapacityInTb;

}
