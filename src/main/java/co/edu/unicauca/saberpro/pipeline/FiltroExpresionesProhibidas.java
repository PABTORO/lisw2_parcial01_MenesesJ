package co.edu.unicauca.saberpro.pipeline;

import co.edu.unicauca.saberpro.model.Pregunta;
/**
 *
 * @author IngSis
 */
public class FiltroExpresionesProhibidas implements IFiltroPregunta{

    @Override
    public boolean procesar(Pregunta pregunta) {
        String prohibido1 = "Todas las anteriores";
        String prohibido2 = "Ninguna de las anteriores";
        boolean con1 = pregunta.getEnunciado().contains(prohibido1);
        boolean con2 = pregunta.getEnunciado().contains(prohibido2);
        boolean con3 = false;
        for (int i = 0; i < pregunta.getOpciones().size(); i++) {
            String opcion = pregunta.getOpciones().get(i);
            if(opcion.contains(prohibido1) || opcion.contains(prohibido2)){
                con3 = true;
            }
        }


        if(con1 || con2 || con3){
            return false;
        }
        return true;
        
    }
}
