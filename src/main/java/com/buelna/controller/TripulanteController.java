package com.buelna.controller;

import com.buelna.dto.TripulanteDTO;
import com.buelna.entities.Tripulante;
import com.buelna.services.TripulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripulantes")
public class TripulanteController {

    @Autowired
    private TripulanteService tripulanteService;

    @GetMapping
    public ResponseEntity<List<Tripulante>> getTripulantes() {

        return ResponseEntity.ok(tripulanteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripulanteDTO> getTripulanteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tripulanteService.getTripulanteById(id));
    }

    @PostMapping
    public ResponseEntity<TripulanteDTO> createTripulante(@RequestBody TripulanteDTO tripulante) {
        TripulanteDTO savedTripulante = tripulanteService.saveTripulante(tripulante);
        return new ResponseEntity<>(savedTripulante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripulanteDTO> updateTripulante(@PathVariable Long id, @RequestBody TripulanteDTO tripulante) {
        TripulanteDTO updatedTripulante = tripulanteService.updateTripulante(tripulante, id);
        return ResponseEntity.ok(updatedTripulante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripulante(@PathVariable Long id) {
        tripulanteService.deleteTripulante(id);
        return ResponseEntity.noContent().build();
    }

}
