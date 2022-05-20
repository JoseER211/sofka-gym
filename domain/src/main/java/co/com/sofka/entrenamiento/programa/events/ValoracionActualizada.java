package co.com.sofka.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.programa.values.Valoracion;

public class ValoracionActualizada extends DomainEvent {
    private final Valoracion valoracion;
    public ValoracionActualizada(Valoracion valoracion) {
        super("sofka.programa.valoracionactualizada");
        this.valoracion = valoracion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }
}

