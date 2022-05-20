package co.com.sofka.entrenamiento.estudio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class EntrenadorExpertoAgregado extends DomainEvent {
    private final EntrenadorExpertoId entrenadorExpertoId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;

    public EntrenadorExpertoAgregado(EntrenadorExpertoId entrenadorExpertoId, Nombre nombre, Celular celular, Correo correo) {
        super("sofka.estudio.entrenadorexpertoagregado");
        this.entrenadorExpertoId = entrenadorExpertoId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public EntrenadorExpertoId getEntrenadorExpertoId() {
        return entrenadorExpertoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public Correo getCorreo() {
        return correo;
    }
}
