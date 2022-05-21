package co.com.sofka.entrenamiento.programa.values;

import co.com.sofka.domain.generic.Identity;

public class ProgramaId extends Identity {
    public ProgramaId() {

    }

    private ProgramaId(String id) {
        super(id);
    }

    public static ProgramaId of(String id) {
        return new ProgramaId(id);
    }
}
