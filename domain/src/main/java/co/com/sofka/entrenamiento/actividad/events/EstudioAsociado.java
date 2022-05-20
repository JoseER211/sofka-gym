package co.com.sofka.entrenamiento.actividad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;

public class EstudioAsociado extends DomainEvent {

    private final EstudioId estudioId;
    public EstudioAsociado(EstudioId estudioId ) {
        super("sofka.actividad.estudioasociado");
        this.estudioId = estudioId;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }
}
