package co.com.sofka.entrenamiento.programa.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;

public class FisioterapeutaId extends Identity {
    public FisioterapeutaId(){

    }

    private FisioterapeutaId(String id){
        super(id);
    }

    public static FisioterapeutaId of(String id){
        return new FisioterapeutaId(id);
    }
}
