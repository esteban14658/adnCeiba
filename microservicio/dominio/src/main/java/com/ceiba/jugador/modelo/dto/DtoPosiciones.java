package com.ceiba.jugador.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPosiciones {

    private Long defensas;
    private Long mediocampistas;
    private Long delanteros;

    public DtoPosiciones() {
        super();
    }

    public DtoPosiciones(Long defensas, Long mediocampistas, Long delanteros) {
        this.defensas = defensas;
        this.mediocampistas = mediocampistas;
        this.delanteros = delanteros;
    }
}
