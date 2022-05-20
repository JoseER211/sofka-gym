package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarEntrenadorExperto extends Command {
    private final EntrenadorExpertoId entrenadorExpertoId;
    private final Nombre nombre;
    private Celular celular;
    private Correo correo;

    public AgregarEntrenadorExperto(EntrenadorExpertoId entrenadorExpertoId, Nombre nombre, Celular celular, Correo correo) {
        this.entrenadorExpertoId = entrenadorExpertoId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
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
