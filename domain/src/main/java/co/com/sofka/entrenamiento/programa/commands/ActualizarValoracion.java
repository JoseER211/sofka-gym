package co.com.sofka.entrenamiento.programa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;
import co.com.sofka.entrenamiento.programa.values.Valoracion;

public class ActualizarValoracion extends Command {
    private final ProgramaId programaId;
    private final Valoracion valoracion;

    public ActualizarValoracion(ProgramaId programaId, Valoracion valoracion) {
        this.programaId = programaId;
        this.valoracion = valoracion;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }
}
