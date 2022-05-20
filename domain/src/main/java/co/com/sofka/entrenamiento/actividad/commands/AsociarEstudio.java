package co.com.sofka.entrenamiento.actividad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;

public class AsociarEstudio extends Command {
    private final ActividadId actividadId;
    private final EstudioId estudioId;

    public AsociarEstudio(ActividadId actividadId, EstudioId estudioId) {
        this.actividadId = actividadId;
        this.estudioId = estudioId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }
}
