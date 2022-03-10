package com.ceiba.asistencia.adaptador.dao;

import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.jugador.adaptador.dao.MapeoJugador;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoAsistencia implements RowMapper<DtoAsistencia>, MapperResult {

    @Override
    public DtoAsistencia mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        MapeoJugador mapeoJugador = new MapeoJugador();

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        DtoJugador jugador = mapeoJugador.mapRow(resultSet, rowNum);
        return new DtoAsistencia(id, fecha, jugador);
    }
}
