package myfilesystem.models;

import java.util.ArrayList;
import java.util.Date;

public class Miembro{
    ArrayList<Pregunta> preguntas;

    public ArrayList<Pregunta> getPreguntasByFecha(Date fechaInicio, Date fechaFin){

        ArrayList<Pregunta> preguntasEnRango = new ArrayList<>();

        for (Pregunta pregunta : preguntas){
            if (pregunta.getFechaCreacion() > fechaInicio && pregunta.getFechaCreacion() < fechaFin){
                    preguntasEnRango.add(pregunta);
            }
            else if (pregunta.getFechaActualizacion() > fechaInicio && pregunta.getFechaActualizacion() < fechaFin){
                    preguntasEnRango.add(pregunta);
            }
        }
        return preguntasEnRango;
    }
}

