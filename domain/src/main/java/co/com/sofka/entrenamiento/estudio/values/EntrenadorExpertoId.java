package co.com.sofka.entrenamiento.estudio.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.entrenamiento.actividad.values.EntrenadorId;

public class EntrenadorExpertoId extends Identity {

    public EntrenadorExpertoId(){

    }

    private EntrenadorExpertoId(String id){
        super(id);
    }

    public static EntrenadorExpertoId of(String id){
        return new EntrenadorExpertoId(id);
    }
}
