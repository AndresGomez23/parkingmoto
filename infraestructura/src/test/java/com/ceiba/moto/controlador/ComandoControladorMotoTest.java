package com.ceiba.moto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.servicio.testdatabuilder.ComandoMotoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ControladorIngresoMoto.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorMotoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia ingresar una moto")
    void deberiaCrearUnaMoto() throws Exception{
        // arrange
        ComandoMoto moto = new ComandoMotoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/ingreso/moto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': AAO71F}"));
    }

    @Test
    @DisplayName("Deberia retirar una moto")
    void deberiaRetirarUnaMoto() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/retirar/{AAO71F}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/retirar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("", hasSize(0)));
    }

}
