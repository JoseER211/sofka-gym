package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.events.EntrenadorExpertoAgregado;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.events.ImplementoAgregado;
import co.com.sofka.entrenamiento.estudio.events.MaquinaAgregada;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.estudio.values.ImplementoId;
import co.com.sofka.entrenamiento.estudio.values.MaquinaId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

import java.util.List;


public class Estudio extends AggregateEvent<EstudioId> {
    protected Nombre nombre;
    protected Descripcion descripcion;
    protected EntrenadorExperto entrenadorExperto;
    protected Implemento implemento;
    protected Maquina maquina;

    public Estudio(EstudioId estudioId, Nombre nombre, Descripcion descripcion) {
        super(estudioId);
        appendChange(new EstudioCreado(nombre, descripcion));
    }

    private Estudio(EstudioId estudioId) {
        super(estudioId);
        subscribe(new EstudioChange(this));
    }

    public static Estudio from(EstudioId estudioId, List<DomainEvent> events) {
        var estudio = new Estudio(estudioId);
        events.forEach(estudio::applyEvent);
        return estudio;
    }

    public void agregarEntrenadorExperto(EntrenadorExpertoId entrenadorExpertoId, Nombre nombre, Celular celular, Correo correo) {
        appendChange(new EntrenadorExpertoAgregado(entrenadorExpertoId, nombre, celular, correo)).apply();
    }

    public void agregarImplemento(ImplementoId implementoId, Nombre nombre, Descripcion descripcion) {
        appendChange(new ImplementoAgregado(implementoId, nombre, descripcion)).apply();
    }

    public void agregarMaquina(MaquinaId maquinaId, Nombre nombre, Descripcion descripcion) {
        appendChange(new MaquinaAgregada(maquinaId, nombre, descripcion)).apply();
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public EntrenadorExperto getEntrenadorExperto() {
        return entrenadorExperto;
    }

    public Implemento getImplemento() {
        return implemento;
    }

    public Maquina getMaquina() {
        return maquina;
    }
}
