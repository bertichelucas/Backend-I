package com.dh.IntegradorV2.dto;

import com.dh.IntegradorV2.model.Odontologo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TurnoDTO {

    private Long id;

    private Long paciente;

    private Long odontologo;

    private LocalDate fecha;

    public TurnoDTO(Long paciente, Long odontologo, LocalDate fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public TurnoDTO(){

    }
}
