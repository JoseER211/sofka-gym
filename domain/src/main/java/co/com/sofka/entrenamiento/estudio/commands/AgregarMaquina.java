package co.com.sofka.entrenamiento.estudio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.estudio.values.MaquinaId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class AgregarMaquina extends Command {
    private final MaquinaId maquinaId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public AgregarMaquina(MaquinaId maquinaId, Nombre nombre, Descripcion descripcion) {
        this.maquinaId = maquinaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
