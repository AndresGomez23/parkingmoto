package com.ceiba.usuario.adaptador.dao;

import java.util.List;
import java.util.Optional;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoMoto;
import com.ceiba.usuario.puerto.dao.DaoMoto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component

public class DaoMotoMysql implements DaoMoto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="sql.usuario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace ="sql.usuario", value ="obtenerPorPlaca")
    private static String sqlObtenerPorPlaca;

    public DaoMotoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMoto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMoto());
    }

    @Override
    public Optional<DtoMoto> obtenerPorPlaca(String placa){
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.consultarUnicoResultado(sqlObtenerPorPlaca, parametros, new MapeoMoto());
    }
}
