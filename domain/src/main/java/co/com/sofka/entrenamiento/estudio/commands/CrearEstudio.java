package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class CrearEstudio extends Command {
    private final EstudioId estudioId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public CrearEstudio(EstudioId estudioId, Nombre nombre, Descripcion descripcion) {
        this.estudioId = estudioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
