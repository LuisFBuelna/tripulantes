package com.buelna.mapper;

import com.buelna.dto.TripulanteDTO;
import com.buelna.entities.Tripulante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TripulanteMapper {

    TripulanteMapper mapper = Mappers.getMapper(TripulanteMapper.class);

    TripulanteDTO tripulanteToTripulanteDTO (Tripulante tripulante);
}
