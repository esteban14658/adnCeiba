package com.ceiba.jugador.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import org.springframework.jdbc.core.RowMapper;

public class MapeoJugador implements RowMapper<DtoJugador>, MapperResult {

    @Override
    public DtoJugador mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long documento = resultSet.getLong("documento");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        float peso = resultSet.getFloat("peso");
        float altura = resultSet.getFloat("altura");
        String posicion = resultSet.getString("posicion");
        String pieHabil = resultSet.getString("pie_habil");

        return new DtoJugador(id, documento, nombre, apellido, fechaNacimiento, peso, altura, posicion, pieHabil);
    }

}

