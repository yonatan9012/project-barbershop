package com.example.project_barbershop.repo;


import com.example.project_barbershop.model.HairMachine;
import org.springframework.data.repository.CrudRepository;

    public interface HairMachineRepository extends CrudRepository<HairMachine,Long> {
        Iterable<HairMachine> findByBrand(String brand);

        Iterable<HairMachine> findByAvailable(Boolean available);

        Iterable<HairMachine> findByPriceLessThan(Double price);

        Iterable<HairMachine> findByBrandAndAvailable(String brand, Boolean available);
    }
