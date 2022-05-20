package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.Identity;

public class ActividadId extends Identity {

    public ActividadId(){

    }

    private ActividadId(String id){
        super(id);
    }

    public static ActividadId of(String id){
        return new ActividadId(id);
    }
}
