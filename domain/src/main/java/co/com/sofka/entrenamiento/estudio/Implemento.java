package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.estudio.values.ImplementoId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class Implemento extends Entity<ImplementoId> {
    private Nombre nombre;
    private Descripcion descripcion;

    public Implemento(ImplementoId implementoId, Nombre nombre, Descripcion descripcion) {
        super(implementoId);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void cambiarInformacion(Nombre nombre, Descripcion descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
