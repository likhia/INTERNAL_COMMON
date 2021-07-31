package com.workshop.common.entity;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {
    List<VehicleEntity> findByUser(String user);

    List<VehicleEntity> findByCarplate(String carplate);

}