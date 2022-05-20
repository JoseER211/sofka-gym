package co.com.sofka.entrenamiento.actividad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.values.EntrenadorId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class EntrenadorAgregado extends DomainEvent {
    private final EntrenadorId entrenadorId;
    private final Nombre nombre;
    private Celular celular;
    private Correo correo;

    public EntrenadorAgregado(EntrenadorId entrenadorId, Nombre nombre, Celular celular, Correo correo) {
        super("sofka.actividad.entrenadoragregado");
        this.entrenadorId = entrenadorId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
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
