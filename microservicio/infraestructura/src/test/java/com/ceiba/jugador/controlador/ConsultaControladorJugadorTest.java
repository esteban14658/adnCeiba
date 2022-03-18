package com.ceiba.jugador.controlador;

import com.ceiba.ApplicationMock;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
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
    @DisplayName("Deberia listar jugadores")
    void deberiaListarJugadores() throws Exception {
        // arrange
        // act - assert
        Integer cantidad = 10;
        Integer pagina = 0;
        mocMvc.perform(get("/jugadores/" + cantidad + "/" + pagina)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].documento", is(80808080)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    @DisplayName("Deberia listar jugadores sin asistencia hoy")
    void deberiaListarJugadoresSinAsistenciaHoy() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/jugadores/asistencia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(14)))
                .andExpect(jsonPath("$[0].documento", is(89808080)))
                .andExpect(jsonPath("$[0].id", is(2)));
    }

    @Test
    @DisplayName("Deberia listar Por categoria")
    void deberiaListarPorCategoria() throws Exception {
        String fecha = "2022";
        mocMvc.perform(get("/jugadores/categoria/" + fecha)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].fechaNacimiento", is(LocalDate.now().toString())));
    }

    @Test
    @DisplayName("Deberia listar el equipo")
    void deberiaListarElEquipo() throws Exception {
        Integer defensas = 4;
        Integer mediocampistas = 4;
        Integer delanteros = 2;
        String url = "/jugadores/equipo?defensas=" + defensas + "&mediocampistas=" + mediocampistas +
                "&delanteros=" + delanteros;
        //... more
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        mocMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
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
