package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoCarro;
import com.ceiba.usuario.puerto.dao.DaoCarro;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoCarroMysql implements DaoCarro {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "sql.carro", value = "listarCarro")
    private static String sqlListarCarro;

    @SqlStatement(namespace = "sql.carro", value = "obtenerPorPlacaCarro")
    private static String sqlObtenerPorPlacaCarro;

    @SqlStatement(namespace = "sql.carro", value = "obtenerPorFiltroCarro")
    private static String sqlObtenerPorFiltroCarro;

    public DaoCarroMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCarro> listarCarro() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarCarro, new MapeoCarro());
    }

    @Override
    public Optional<DtoCarro> obtenerPorPlacaCarro(String placa) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.consultarUnicoResultado(sqlObtenerPorPlacaCarro, parametros, new MapeoCarro());
    }

    @Override
    public List<DtoCarro> obtenerPorFiltroCarro(String placa) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("placa", "%".concat(placa).concat("%"));
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorFiltroCarro, parametros, new MapeoCarro());
    }
}