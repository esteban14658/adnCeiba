package com.ceiba.factura.adaptador.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFacturaMysql implements RepositorioFactura{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="factura", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="factura", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="factura", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="factura", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="factura", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace = "factura", value = "existePorDoc")
    private static String sqlExistePorDocumento;

    @SqlStatement(namespace = "factura", value = "existePorIdJugador")
    private static String sqlExistePorIdJugador;

    public RepositorioFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Factura factura) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("valor", factura.getValor());
        parameterSource.addValue("fechaIngreso", factura.getFechaIngreso());
        parameterSource.addValue("fechaCaducidad", factura.getFechaCaducidad());
        parameterSource.addValue("jugador", factura.getJugador().getId());
        parameterSource.addValue("estado", factura.getEstado());
        parameterSource.addValue("descripcion", factura.getDescripcion());
        return Long.valueOf(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, parameterSource));
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
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
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorDocumento,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorIdJugador(Long jugador) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("jugador", jugador);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdJugador,paramSource, Boolean.class);
    }
}
