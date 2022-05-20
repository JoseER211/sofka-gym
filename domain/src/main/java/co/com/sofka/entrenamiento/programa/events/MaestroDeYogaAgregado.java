package co.com.sofka.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.MaestroDeYogaId;

public class MaestroDeYogaAgregado extends DomainEvent {
    private final MaestroDeYogaId maestroDeYogaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    public MaestroDeYogaAgregado(MaestroDeYogaId maestroDeYogaId, Nombre nombre, Celular celular, Correo correo) {
        super("sofka.programa.maestrodeyogaagregado");
        this.maestroDeYogaId = maestroDeYogaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public MaestroDeYogaId getMaestroDeYogaId() {
        return maestroDeYogaId;
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
