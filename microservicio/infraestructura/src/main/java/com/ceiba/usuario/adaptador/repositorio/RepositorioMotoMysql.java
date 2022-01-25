package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.puerto.repositorio.RepositorioMoto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMotoMysql implements RepositorioMoto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "sql.usuario", value="prueba")
    private static String sqlCrear;

    @SqlStatement(namespace= "sql.usuario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace= "sql.usuario", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace= "sql.usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace= "sql.usuario", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioMotoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public String crear(Moto moto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", moto.getPlaca());
        paramSource.addValue("casco", moto.getCasco());
        paramSource.addValue("cilindraje", moto.getCilindraje());
        paramSource.addValue("fechaIngreso", moto.getFechaIngreso());
        this.customNamedParameterJdbcTemplate.guardar(paramSource, sqlCrear);
        return moto.getPlaca();
    }

    @Override
    public void eliminar(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Moto moto) {
        this.customNamedParameterJdbcTemplate.actualizar(moto, sqlActualizar);
    }
}
