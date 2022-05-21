package co.com.sofka.entrenamiento.estudio.values;

import co.com.sofka.domain.generic.Identity;

public class EntrenadorExpertoId extends Identity {

    public EntrenadorExpertoId() {

    }

    private EntrenadorExpertoId(String id) {
        super(id);
    }

    public static EntrenadorExpertoId of(String id) {
        return new EntrenadorExpertoId(id);
    }
}
