package com.james.wagstaff.polymorphism.controllers;

import com.james.wagstaff.polymorphism.entities.Warehouse;
import com.james.wagstaff.polymorphism.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public Warehouse createWareHouseWithStock(@RequestBody Warehouse warehouse) {
        return warehouseService.createWarehouseWithStock(warehouse);
    }

    @GetMapping
    public Iterable<Warehouse> getAllWarehousesAndStock() {
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getAllWarehousesAndStockById(@PathVariable Long id) {
        return warehouseService.findById(id);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehousesAndStockById(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        return warehouseService.updateStockByWarehouseById(id, warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouseById(@PathVariable Long id) {
        warehouseService.deleteWarehouseById(id);
    }
}
