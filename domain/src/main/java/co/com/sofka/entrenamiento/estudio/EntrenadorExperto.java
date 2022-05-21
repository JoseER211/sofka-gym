package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class EntrenadorExperto extends Entity<EntrenadorExpertoId> {
    private Nombre nombre;
    private Celular celular;
    private Correo correo;

    public EntrenadorExperto(EntrenadorExpertoId entrenadorExpertoId, Nombre nombre, Celular celular, Correo correo) {
        super(entrenadorExpertoId);
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public void cambiarInformacion(Nombre nombre, Celular celular, Correo correo) {
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
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
