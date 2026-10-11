package co.edu.unicauca.saberpro.pipeline;

import co.edu.unicauca.saberpro.model.Pregunta;

public class FiltroOpciones implements IFiltroPregunta {
    @Override
    public boolean procesar(Pregunta pregunta) {
        if (pregunta == null || pregunta.getOpciones() == null) {
            return false;
        }
        //Se arreglo la logica invertida, ahora retorna true si tiene exactamente 4 opciones
        return pregunta.getOpciones().size() == 4;
    }
}