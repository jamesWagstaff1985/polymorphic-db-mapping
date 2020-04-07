package com.james.wagstaff.polymorphism.services;

import com.james.wagstaff.polymorphism.entities.Warehouse;
import com.james.wagstaff.polymorphism.repositories.IWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final IWarehouseRepository warehouseRepository;

    public Warehouse createWarehouseWithStock(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Iterable<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new NullPointerException(String.format("No warehouse found with id %s", id)));
    }

    public Warehouse updateStockByWarehouseById(Long id, Warehouse warehouse) {
        Warehouse existingWarehouse = findById(id);
        existingWarehouse.setStock(warehouse.getStock());
        return warehouseRepository.save(existingWarehouse);
    }

    public void deleteWarehouseById(Long id) {
        warehouseRepository.deleteById(id);
    }
}
