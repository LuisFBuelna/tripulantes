package com.buelna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripulanteDTO implements Serializable {

    private String name;
    private String role;
    private Date registeredAt;
}
