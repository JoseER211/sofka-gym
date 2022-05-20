package co.com.sofka.entrenamiento.actividad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

import java.util.Set;

public class AgregarEjercicio extends Command {
    private final ActividadId actividadId;
    private final EjercicioId ejercicioId;
    private final Nombre nombre;
    private final Ronda ronda;
    private final Repeticion repeticion;
    private final Tiempo tiempo;
    private final Set<Material> materials;
    private final Descripcion descripcion;

    public AgregarEjercicio(ActividadId actividadId, EjercicioId ejercicioId, Nombre nombre, Ronda ronda, Repeticion repeticion, Tiempo tiempo, Set<Material> materials, Descripcion descripcion) {
        this.actividadId = actividadId;
        this.ejercicioId = ejercicioId;
        this.nombre = nombre;
        this.ronda = ronda;
        this.repeticion = repeticion;
        this.tiempo = tiempo;
        this.materials = materials;
        this.descripcion = descripcion;
    }

    public ActividadId getActividadId() {
        return actividadId;
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
