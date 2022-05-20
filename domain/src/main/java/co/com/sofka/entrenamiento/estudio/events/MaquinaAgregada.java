package co.com.sofka.entrenamiento.estudio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.Maquina;
import co.com.sofka.entrenamiento.estudio.values.MaquinaId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class MaquinaAgregada extends DomainEvent {
    private final MaquinaId maquinaId;
    private final Nombre nombre;
    private final Descripcion descripcion;
    public MaquinaAgregada(MaquinaId maquinaId,  Nombre nombre, Descripcion descripcion ) {
        super("sofka.estudio.maquinaagregada");
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
