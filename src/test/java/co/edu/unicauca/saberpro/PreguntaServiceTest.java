/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.saberpro;
/**
 *
 * @author IngSis
 */

import co.edu.unicauca.saberpro.model.Pregunta;
import co.edu.unicauca.saberpro.pipeline.FiltroEnunciado;
import co.edu.unicauca.saberpro.pipeline.FiltroOpciones;
import co.edu.unicauca.saberpro.pipeline.ValidadorPipeline;
import co.edu.unicauca.saberpro.repository.IPreguntaRepository;
import co.edu.unicauca.saberpro.repository.PreguntaRepositoryImpl;
import co.edu.unicauca.saberpro.service.IPreguntaService;
import co.edu.unicauca.saberpro.service.PreguntaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaServiceTest {

    private IPreguntaService preguntaService;

    @BeforeEach
    void setUp() {
        // inicio las dependencias (reales)
        IPreguntaRepository repository = new PreguntaRepositoryImpl();
        ValidadorPipeline pipeline = new ValidadorPipeline();
        
        //agrego los filtros base
        pipeline.addFiltro(new FiltroEnunciado());
        pipeline.addFiltro(new FiltroOpciones());
        
        preguntaService = new PreguntaServiceImpl(repository, pipeline);
    }

    @Test
    void testRegistrarPreguntaValida() {
        // Pregunta con enunciado bien y las 4 opciones
        Pregunta p = new Pregunta(
            1,
            "¿Cuál es la capital de Colombia?",
            Arrays.asList("Bogotá", "Cali", "Medellín", "Cartagena"),
            "Bogotá",
            "Borrador"
        );

        boolean resultado = preguntaService.registrarPregunta(p);
        
        assertTrue(resultado, "La pregunta debería registrarse con éxito en el pipeline.");
        assertEquals(1, preguntaService.obtenerTodas().size(), "El banco de preguntas debe contener 1 elemento.");
    }

    @Test
    void testRegistrarPreguntaInvalidaOpciones() {
        // Pregunta que tiene menos de 4 opciones (no pasa)
        Pregunta p = new Pregunta(
            2,
            "¿Pregunta con opciones incompletas?",
            Arrays.asList("Opción A", "Opción B"),
            "Opción A",
            "Borrador"
        );

        boolean resultado = preguntaService.registrarPregunta(p);
        
        assertFalse(resultado, "La pregunta NO debería registrarse porque tiene menos de 4 opciones.");
        assertTrue(preguntaService.obtenerTodas().isEmpty(), "El banco de preguntas debe estar vacío.");
    }
}
