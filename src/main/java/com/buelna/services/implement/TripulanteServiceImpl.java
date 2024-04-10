package com.buelna.services.implement;

import com.buelna.dto.TripulanteDTO;
import com.buelna.entities.Tripulante;
import com.buelna.exceptions.NotFoundException;
import com.buelna.mapper.TripulanteMapper;
import com.buelna.repository.TripulanteRepository;
import com.buelna.services.TripulanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripulanteServiceImpl implements TripulanteService {

    @Autowired
    private TripulanteRepository tripulanteRepository;

    @Override
    public List<Tripulante> getAll() {
        return tripulanteRepository.findAll();
    }

    @Override
    public TripulanteDTO getTripulanteById(Long id) {
        Tripulante tripulante = tripulanteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El tripulante no fue encontrado"));
        return TripulanteMapper.mapper.tripulanteToTripulanteDTO(tripulante);
    }

    @Override
    public TripulanteDTO saveTripulante(TripulanteDTO tripulante) {
        try {
            Tripulante createTripulante = new Tripulante(
                    tripulante.getName(),
                    tripulante.getRole(),
                    Date.valueOf(LocalDate.now()),
                    tripulante.getNaveId());

            return TripulanteMapper.mapper.tripulanteToTripulanteDTO(tripulanteRepository.save(createTripulante));
        } catch (Exception exception) {
            throw new RuntimeException("Ha ocurrido un problema con la aplicacion");
        }
    }

    @Override
    public TripulanteDTO updateTripulante(TripulanteDTO tripulante, Long id) {

        try {
            Optional<Tripulante> findTripulante = tripulanteRepository.findById(id);

            if (findTripulante.isEmpty()) {
                throw new NotFoundException("El tripulante no fue encontrado");
            }

            Tripulante updateTripulante = findTripulante.get();
            updateTripulante.setName(tripulante.getName());
            updateTripulante.setRole(tripulante.getRole());
            updateTripulante.setNaveId(tripulante.getNaveId());

            return TripulanteMapper.mapper.tripulanteToTripulanteDTO(tripulanteRepository.save(updateTripulante));
        } catch (Exception exception) {
            throw new RuntimeException("Ha ocurrido un problema con la aplicacion");
        }
    }

    @Override
    public void deleteTripulante(Long id) {
        Optional<Tripulante> findTripulante = tripulanteRepository.findById(id);

        if (findTripulante.isEmpty()) {
            throw new NotFoundException("El tripulante no fue encontrado");
        }
        tripulanteRepository.deleteById(id);
    }

}
