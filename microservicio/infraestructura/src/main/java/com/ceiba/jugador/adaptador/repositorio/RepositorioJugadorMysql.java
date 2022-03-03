package com.ceiba.jugador.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.jugador.modelo.entidad.Jugador;
import com.ceiba.jugador.puerto.repositorio.RepositorioJugador;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioJugadorMysql implements RepositorioJugador {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="jugador", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="jugador", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="jugador", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="jugador", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="jugador", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="jugador", value="existePorDoc")
    private static String sqlExistePorDoc;

    public RepositorioJugadorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Jugador jugador) {
        return this.customNamedParameterJdbcTemplate.crear(jugador, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Jugador jugador) {
        this.customNamedParameterJdbcTemplate.actualizar(jugador, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorDocumento(Long documento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documento", documento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorDoc,paramSource, Boolean.class);
    }
}
