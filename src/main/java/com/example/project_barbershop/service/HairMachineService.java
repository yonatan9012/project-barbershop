package com.example.project_barbershop.service;


import com.example.project_barbershop.model.HairMachine;
import com.example.project_barbershop.repo.HairMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HairMachineService {
        @Autowired
        HairMachineRepository repository;

        public Iterable<HairMachine> all() {
            return repository.findAll();
        }

        public Optional<HairMachine> findById(Long id) {
            return repository.findById(id);
        }

        public  HairMachine save(HairMachine hairMachine) {
            return repository.save(hairMachine);
        }

        public void delete(HairMachine hairMachine) {
            repository.delete(hairMachine);
        }


        public Iterable<HairMachine> findByBrand(String brand) {
            return repository.findByBrand(brand);
        }


        public Iterable<HairMachine> findByAvailable(Boolean available) {
            return repository.findByAvailable(available);
        }


        public Iterable<HairMachine> findByPriceLessThan(Double price) {
            return repository.findByPriceLessThan(price);
        }


        public Iterable<HairMachine> findByBrandAndAvailable(String brand, Boolean available) {
            return repository.findByBrandAndAvailable(brand, available);
        }
}

