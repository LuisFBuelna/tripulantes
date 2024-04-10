package com.buelna.services;

import com.buelna.dto.TripulanteDTO;
import com.buelna.entities.Tripulante;

import java.util.List;

public interface TripulanteService {
    List<Tripulante> getAll();

    TripulanteDTO getTripulanteById(Long id);

    TripulanteDTO saveTripulante(TripulanteDTO tripulante);

    TripulanteDTO updateTripulante(TripulanteDTO tripulanteDTO, Long id);

    void deleteTripulante(Long id);
}
