package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Carro;
import com.ceiba.usuario.modelo.entidad.Moto;
import com.ceiba.usuario.puerto.repositorio.RepositorioCarro;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCarroMysql implements RepositorioCarro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "sql.carro", value="crearCarro")
    private static String sqlCrearCarro;

    @SqlStatement(namespace= "sql.carro", value="actualizarCarro")
    private static String sqlActualizarCarro;

    @SqlStatement(namespace= "sql.carro", value="existeCarro")
    private static String sqlExisteCarro;

    @SqlStatement(namespace= "sql.carro", value="existePorIdCarro")
    private static String sqlExistePorIdCarro;

    public RepositorioCarroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public String crearCarro(Carro carro) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", carro.getPlaca());
        paramSource.addValue("cilindraje", carro.getCilindraje());
        paramSource.addValue("fechaIngreso", carro.getFechaIngreso());
        this.customNamedParameterJdbcTemplate.guardar(paramSource, sqlCrearCarro);
        return carro.getPlaca();
    }

    @Override
    public boolean existeCarro(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCarro,paramSource, Boolean.class);
    }

    @Override
    public void actualizarCarro(Carro carro) {
        this.customNamedParameterJdbcTemplate.actualizar(carro, sqlActualizarCarro);
    }
}
