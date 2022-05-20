package co.com.sofka.entrenamiento.actividad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.actividad.values.EntrenadorId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarEntrenador extends Command {
    private final EntrenadorId entrenadorId;
    private final Nombre nombre;
    private Celular celular;
    private Correo correo;

    public AgregarEntrenador(EntrenadorId entrenadorId, Nombre nombre, Celular celular, Correo correo) {
        this.entrenadorId = entrenadorId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public EntrenadorId getEntrenadorId() {
        return entrenadorId;
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
