package com.ceiba.jugador.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.jugador.modelo.dto.DtoJugador;
import com.ceiba.jugador.puerto.dao.DaoJugador;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoJugadorMysql implements DaoJugador {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "jugador", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace= "jugador", value="listarPorPosicion")
    private static String sqlListarPorPosicion;

    @SqlStatement(namespace= "jugador", value="listarPorPieHabil")
    private static String sqlListarPorPieHabil;

    @SqlStatement(namespace= "jugador", value="obtenerPorDocumento")
    private static String sqlObtener;

    public DaoJugadorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoJugador> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoJugador());
    }

    @Override
    public List<DtoJugador> listarPorPosicion(String posicion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("posicion", posicion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPosicion, paramSource, new MapeoJugador());
    }

    @Override
    public List<DtoJugador> listarPorPieHabil(String pieHabil) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pieHabil", pieHabil);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPieHabil, paramSource, new MapeoJugador());
    }

    @Override
    public DtoJugador obtenerPorDocumento(Long documento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documento", documento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, paramSource, new MapeoJugador());
    }
}
