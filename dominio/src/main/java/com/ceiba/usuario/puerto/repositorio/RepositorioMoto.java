package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Moto;


public interface RepositorioMoto {
    /**
     * Permite crear una moto
     * @param moto
     * @return la placa generado
     */
    String crear(Moto moto);

    /**
     * Permite actualizar la placa
     * @param moto
     */
    void actualizar(Moto moto);

    /**
     * Permite eliminar la placa
     * @param placa
     */
    String eliminar(String placa);

    /**
     * Permite validar si existe la moto con un la placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

}

