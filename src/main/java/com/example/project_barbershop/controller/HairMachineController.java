package com.example.project_barbershop.controller;

import com.example.project_barbershop.dto.HairMachineIn;
import com.example.project_barbershop.model.HairMachine;
import com.example.project_barbershop.service.HairMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/machines")
public class HairMachineController {
        @Autowired
        HairMachineService hairMachineService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllMachines() {
            return new ResponseEntity<>(hairMachineService.all(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getOneMachine(@PathVariable Long id) {
            return new ResponseEntity<>(hairMachineService.findById(id), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<?> insertMachine(@RequestBody HairMachineIn machineIn) {
            HairMachine machine = machineIn.toHairMachine(machineIn);
            machine = hairMachineService.save(machine);
            return new ResponseEntity<>(machine, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateMachine(
                @PathVariable Long id,
                @RequestBody HairMachineIn machineIn) {

            Optional<HairMachine> dbMachine = hairMachineService.findById(id);
            machineIn.updateHairMachine(dbMachine.get());
            HairMachine updatedMachine = hairMachineService.save(dbMachine.get());

            return new ResponseEntity<>(updatedMachine, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteMachine(@PathVariable Long id) {
            Optional<HairMachine> dbMachine = hairMachineService.findById(id);
            hairMachineService.delete(dbMachine.get());
            return new ResponseEntity<>("DELETED", HttpStatus.OK);
        }

        @GetMapping("/brand/{brand}")
        public ResponseEntity<?> getByBrand(@PathVariable String brand) {
            return new ResponseEntity<>(
                    hairMachineService.findByBrand(brand),
                    HttpStatus.OK
            );
        }

        @GetMapping("/available/{available}")
        public ResponseEntity<?> getByAvailable(@PathVariable Boolean available) {
            return new ResponseEntity<>(
                    hairMachineService.findByAvailable(available),
                    HttpStatus.OK
            );
        }

        @GetMapping("/price/{price}")
        public ResponseEntity<?> getByPriceLessThan(@PathVariable Double price) {
            return new ResponseEntity<>(
                    hairMachineService.findByPriceLessThan(price),
                    HttpStatus.OK
            );
        }

        @GetMapping("/brand/{brand}/available/{available}")
        public ResponseEntity<?> getByBrandAndAvailable(
                @PathVariable String brand,
                @PathVariable Boolean available) {

            return new ResponseEntity<>(
                    hairMachineService.findByBrandAndAvailable(brand, available),
                    HttpStatus.OK
            );
        }
}


