package co.com.sofka.entrenamiento.programa.values;

import co.com.sofka.domain.generic.Identity;

public class MaestroDeYogaId extends Identity {
    public MaestroDeYogaId(){

    }

    private MaestroDeYogaId(String id){
        super(id);
    }

    public static MaestroDeYogaId of(String id){
        return new MaestroDeYogaId(id);
    }
}
