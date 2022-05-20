package co.com.sofka.entrenamiento.programa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.MaestroDeYogaId;

public class MaestroDeYoga extends Entity<MaestroDeYogaId> {
    private Nombre nombre;
    private Celular celular;
    private Correo correo;

    public MaestroDeYoga(MaestroDeYogaId maestroDeYogaId, Nombre nombre, Celular celular, Correo correo) {
        super(maestroDeYogaId);
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
