package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.estudio.values.MaquinaId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarMaquina extends Command {
    private final EstudioId estudioId;
    private final MaquinaId maquinaId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public AgregarMaquina(EstudioId estudioId, MaquinaId maquinaId, Nombre nombre, Descripcion descripcion) {
        this.estudioId = estudioId;
        this.maquinaId = maquinaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public MaquinaId getMaquinaId() {
        return maquinaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
