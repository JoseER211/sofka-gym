package co.com.sofka.entrenamiento.estudio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.values.ImplementoId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class ImplementoAgregado extends DomainEvent {
    private final ImplementoId implementoId;
    private final Nombre nombre;
    private final Descripcion descripcion;
    public ImplementoAgregado(ImplementoId implementoId, Nombre nombre, Descripcion descripcion) {
        super("sofka.estudio.implementoagregado");
        this.implementoId = implementoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
