package co.com.sofka.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.Valoracion;

public class ProgramaCreado extends DomainEvent {
    private final Nombre nombre;
    private final Valoracion valoracion;

    public ProgramaCreado(Nombre nombre, Valoracion valoracion) {
        super("sofka.programa.programacreado");
        this.nombre = nombre;
        this.valoracion = valoracion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }
}
