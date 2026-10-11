package co.edu.unicauca.saberpro.model;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private int id;
    private String enunciado;
    private List<String> opciones; // Debe contener 4 opciones
    private String respuestaCorrecta;
    private String estado; // "Borrador", "Publicada"

    public Pregunta(int id, String enunciado, List<String> opciones, String respuestaCorrecta, String estado) {
        this.id = id;
        this.enunciado = enunciado;
        //Se agrego inicializacion segura por si la lista de opciones llega nula
        this.opciones = (opciones == null) ? new ArrayList<>() : new ArrayList<>(opciones);
        this.respuestaCorrecta = respuestaCorrecta;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getEnunciado() { return enunciado; }
    public List<String> getOpciones() { return opciones; }
    public String getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}