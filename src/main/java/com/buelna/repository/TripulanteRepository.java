package com.buelna.repository;

import com.buelna.entities.Tripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {

}
