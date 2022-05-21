package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.actividad.values.EntrenadorId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class Entrenador extends Entity<EntrenadorId> {
    private Nombre nombre;
    private Celular celular;
    private Correo correo;

    public Entrenador(EntrenadorId entrenadorId, Nombre nombre, Celular celular, Correo correo) {
        super(entrenadorId);
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
