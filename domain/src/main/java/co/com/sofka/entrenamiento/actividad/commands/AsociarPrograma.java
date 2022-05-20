package co.com.sofka.entrenamiento.actividad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

public class AsociarPrograma extends Command {
    private final ActividadId actividadId;
    private final ProgramaId programaId;

    public AsociarPrograma(ActividadId actividadId, ProgramaId programaId) {
        this.actividadId = actividadId;
        this.programaId = programaId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
