package co.com.sofka.entrenamiento.actividad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

import java.util.Set;

public class EjercicioAgregado extends DomainEvent {
    private final EjercicioId ejercicioId;
    private final Nombre nombre;
    private final Ronda ronda;
    private final Repeticion repeticion;
    private final Tiempo tiempo;
    private final Set<Material> materials;
    private final Descripcion descripcion;
    public EjercicioAgregado(EjercicioId ejercicioId, Nombre nombre, Ronda ronda, Repeticion repeticion, Tiempo tiempo, Set<Material> materials, Descripcion descripcion) {
        super("sofka.actividad.ejercicioagregado");
        this.ejercicioId = ejercicioId;
        this.nombre = nombre;
        this.ronda = ronda;
        this.repeticion = repeticion;
        this.tiempo = tiempo;
        this.materials = materials;
        this.descripcion = descripcion;
    }

    public EjercicioId getEjercicioId() {
        return ejercicioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public Repeticion getRepeticion() {
        return repeticion;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
