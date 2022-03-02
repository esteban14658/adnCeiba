package com.ceiba.factura.adaptador.dao;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.jugador.adaptador.dao.MapeoJugador;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import org.springframework.jdbc.core.RowMapper;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult {

    @Override
    public DtoFactura mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        MapeoJugador mapeoJugador = new MapeoJugador();

        Long id = resultSet.getLong("id");
        Integer valor = resultSet.getInt("valor");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        LocalDate fechaCaducidad = extraerLocalDate(resultSet, "fecha_caducidad");
        DtoJugador jugador = mapeoJugador.mapRow(resultSet, rowNum);
        Integer estado = resultSet.getInt("estado");
        String descripcion = resultSet.getString("descripcion");

        return new DtoFactura(id, valor, fechaIngreso, fechaCaducidad, jugador, estado, descripcion);

    }
}
