/**package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarMotoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del usuario")
    void deberiaValidarLaExistenciaPreviaDelUsuario() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarMoto servicioActualizarMoto = new ServicioActualizarMoto(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarMoto.ejecutar(usuario), ExcepcionDuplicidad.class,"El no usuario existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarMoto servicioActualizarMoto = new ServicioActualizarMoto(repositorioUsuario);
        // act
        servicioActualizarMoto.ejecutar(usuario);
        //assert
        Mockito.verify(repositorioUsuario,Mockito.times(1)).actualizar(usuario);
    }
}**/
