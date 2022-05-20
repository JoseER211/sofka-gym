package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.Implemento;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.estudio.values.ImplementoId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarImplemento extends Command {
    private final EstudioId estudioId;
    private final ImplementoId implementoId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public AgregarImplemento(EstudioId estudioId, ImplementoId implementoId, Nombre nombre, Descripcion descripcion) {
        this.estudioId = estudioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.implementoId = implementoId;

    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public ImplementoId getImplementoId() {
        return implementoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
