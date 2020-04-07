package com.james.wagstaff.polymorphism.repositories;

import com.james.wagstaff.polymorphism.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
}
