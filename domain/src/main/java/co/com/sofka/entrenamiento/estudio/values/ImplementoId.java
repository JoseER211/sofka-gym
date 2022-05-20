package co.com.sofka.entrenamiento.estudio.values;

import co.com.sofka.domain.generic.Identity;

public class ImplementoId extends Identity {

    public ImplementoId(){

    }

    private ImplementoId(String id){
        super(id);
    }

    public static ImplementoId of(String id){
        return new ImplementoId(id);
    }
}
