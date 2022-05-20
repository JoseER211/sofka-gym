package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarEntrenadorExperto extends Command {
    private final EstudioId estudioId;
    private final EntrenadorExpertoId entrenadorExpertoId;
    private final Nombre nombre;
    private Celular celular;
    private Correo correo;

    public AgregarEntrenadorExperto(EstudioId estudioId, EntrenadorExpertoId entrenadorExpertoId, Nombre nombre, Celular celular, Correo correo) {
        this.estudioId = estudioId;
        this.entrenadorExpertoId = entrenadorExpertoId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;

    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public EntrenadorExpertoId getEntrenadorExpertoId() {
        return entrenadorExpertoId;
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
