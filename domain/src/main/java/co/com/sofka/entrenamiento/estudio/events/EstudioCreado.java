package co.com.sofka.entrenamiento.estudio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class EstudioCreado extends DomainEvent {

    private final Nombre nombre;
    private final Descripcion descripcion;

    public EstudioCreado(Nombre nombre, Descripcion descripcion) {
        super("sofka.estudio.estudiocreado");
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
