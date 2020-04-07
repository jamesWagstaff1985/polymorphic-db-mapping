package com.james.wagstaff.polymorphism.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Slf4j
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<AWarehouseItem> stock = new ArrayList<>();

    public void setStock(Iterable<AWarehouseItem> warehouseItems) {
        warehouseItems.forEach(item -> {
            stock.add(item);
            item.setWarehouse(this);
        });
    }
}
