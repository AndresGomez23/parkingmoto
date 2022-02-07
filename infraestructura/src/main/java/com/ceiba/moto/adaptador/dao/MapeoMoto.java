package com.ceiba.moto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.jdbc.core.RowMapper;



public class MapeoMoto implements RowMapper<DtoMoto>, MapperResult {

        @Override
        public DtoMoto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            String placa = resultSet.getString("placa");
            int casco = resultSet.getInt("casco");
            String cilindraje = resultSet.getString("cilindraje");
            LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_ingreso");

            return new DtoMoto(placa,casco,cilindraje,fecha);
        }
    }
