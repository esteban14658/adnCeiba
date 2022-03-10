package com.ceiba.asistencia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.asistencia.comando.ComandoAsistencia;
import com.ceiba.asistencia.testdatabuilder.ComandoAsistenciaTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAsistencia.class)
public class ComandoControladorAsistenciaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una asistencia")
    public void deberiaCrearUnaAsistencia() throws Exception{
        // arrange
        ComandoAsistencia comandoAsistencia = new ComandoAsistenciaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/asistencias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoAsistencia)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }
}
