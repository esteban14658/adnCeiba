package com.ceiba.jugador.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.jugador.comando.ComandoJugador;
import com.ceiba.jugador.testdatabuilder.ComandoJugadorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorJugador.class)
public class ComandoControladorJugadorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un jugador")
    public void deberiaCrearUnJugador() throws Exception{
        // arrange
        ComandoJugador comandoJugador = new ComandoJugadorTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/jugadores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoJugador)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 16}"));
    }

}
