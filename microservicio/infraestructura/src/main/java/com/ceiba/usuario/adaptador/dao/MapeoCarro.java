package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCarro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCarro implements RowMapper<DtoCarro>, MapperResult {
    @Override
    public DtoCarro mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String placa = resultSet.getString("placa");
        String cilindraje = resultSet.getString("cilindraje");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_ingreso");

        return new DtoCarro(placa,cilindraje,fecha);
    }
}
