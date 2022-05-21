package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.Identity;

public class EjercicioId extends Identity {

    public EjercicioId() {

    }

    private EjercicioId(String id) {
        super(id);
    }

    public static EjercicioId of(String id) {
        return new EjercicioId(id);
    }
}
