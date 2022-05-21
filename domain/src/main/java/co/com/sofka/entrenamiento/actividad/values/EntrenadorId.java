package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorId extends Identity {

    public EntrenadorId() {

    }

    private EntrenadorId(String id) {
        super(id);
    }

    public static EntrenadorId of(String id) {
        return new EntrenadorId(id);
    }
}
