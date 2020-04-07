package com.james.wagstaff.polymorphism.entities;

import com.fasterxml.jackson.annotation.*;
import com.james.wagstaff.polymorphism.entities.warehouse.products.Bed;
import com.james.wagstaff.polymorphism.entities.warehouse.products.Computer;
import com.james.wagstaff.polymorphism.entities.warehouse.products.Iron;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Computer.class, name = "Computer"),
        @JsonSubTypes.Type(value = Iron.class, name = "Iron"),
        @JsonSubTypes.Type(value = Bed.class, name = "Bed"),
})
public abstract class AWarehouseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(length = 30)
    private String manufacturer;

    @Column(length = 30)
    private String model;

    @Column(length = 100)
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable=false)
    private Warehouse warehouse;

}
