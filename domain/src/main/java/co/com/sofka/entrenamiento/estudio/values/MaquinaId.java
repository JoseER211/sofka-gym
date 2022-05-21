package co.com.sofka.entrenamiento.estudio.values;

import co.com.sofka.domain.generic.Identity;

public class MaquinaId extends Identity {


    public MaquinaId() {

    }

    private MaquinaId(String id) {
        super(id);
    }

    public static MaquinaId of(String id) {
        return new MaquinaId(id);
    }
}
