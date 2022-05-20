package co.com.sofka.entrenamiento.programa.values;

import co.com.sofka.domain.generic.Identity;

public class NutricionistaId extends Identity{
    public NutricionistaId(){

    }

    private NutricionistaId(String id){
        super(id);
    }

    public static NutricionistaId of(String id){
        return new NutricionistaId(id);
    }
}
