package co.com.sofka.entrenamiento.actividad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

public class ProgramaAsociado extends DomainEvent {

    private final ProgramaId programaId;

    public ProgramaAsociado(ProgramaId programaId) {
        super("sofka.actividad.programaasociado");
        this.programaId = programaId;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
