package com.ceiba.jugador.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.jugador.modelo.dto.DtoPosiciones;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorJugador.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorJugadorTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar usuarios")
    void deberiaListarJugadores() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/jugadores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].documento", is(80808080)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    @DisplayName("Deberia listar PorPosicion")
    void deberiaListarPorPosicion() throws Exception {
        String posicion = "Delantero";
        mocMvc.perform(get("/jugadores/" + posicion)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].posicion", is("Delantero")));
    }

    @Test
    @DisplayName("Deberia listar PorPosicion")
    void deberiaListarPorPieHabil() throws Exception {
        String pieHabil = "Derecho";
        mocMvc.perform(get("/jugadores/jugadores/" + pieHabil)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].pieHabil", is("Derecho")));
    }

    @Test
    @DisplayName("Deberia listar el equipo")
    void deberiaListarElEquipo() throws Exception {
        String url = "/jugadores/equipo";
        DtoPosiciones dtoPosiciones = new DtoPosiciones(4L, 4L, 2L);
        //... more
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoPosiciones);

        mocMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia obtener un jugador por el documento")
    void deberiaObtenerUnJugadorPorElDocumento() throws Exception {
        String documento = "80808080";
        mocMvc.perform(get("/jugadores/jugador/" + documento)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Juanito")))
                .andExpect(jsonPath("$.posicion", is("Portero")));
    }

}
