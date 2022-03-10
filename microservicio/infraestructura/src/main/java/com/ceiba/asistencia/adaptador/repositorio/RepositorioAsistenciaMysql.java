package com.ceiba.asistencia.adaptador.repositorio;

import com.ceiba.asistencia.modelo.entidad.Asistencia;
import com.ceiba.asistencia.puerto.repositorio.RepositorioAsistencia;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioAsistenciaMysql implements RepositorioAsistencia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "asistencia", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "asistencia", value= "registroDiario")
    private static String sqlRegistroDiario;

    public RepositorioAsistenciaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Asistencia asistencia) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha", LocalDate.now());
        parameterSource.addValue("jugador", asistencia.getJugador().getId());
        return Long.valueOf(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, parameterSource));
    }

    @Override
    public boolean registroDiario(Long idJugador) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("jugador", idJugador);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlRegistroDiario,paramSource, Boolean.class);
    }
}
