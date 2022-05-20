package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

import java.util.Set;

public class Ejercicio extends Entity<EjercicioId> {
    private Nombre nombre;
    private Ronda ronda;
    private Repeticion repeticion;
    private Tiempo tiempo;
    private Set<Material> materials;
    private Descripcion descripcion;

    public Ejercicio(EjercicioId ejercicioId, Nombre nombre, Ronda ronda, Repeticion repeticion, Tiempo tiempo, Set<Material> materials, Descripcion descripcion) {
        super(ejercicioId);
        this.nombre = nombre;
        this.ronda = ronda;
        this.repeticion = repeticion;
        this.tiempo = tiempo;
        this.materials = materials;
        this.descripcion = descripcion;
    }

    public void cambiarInformacion(Nombre nombre, Ronda ronda, Repeticion repeticion, Tiempo tiempo, Set<Material> materials, Descripcion descripcion){
        this.nombre = nombre;
        this.ronda = ronda;
        this.repeticion = repeticion;
        this.tiempo = tiempo;
        this.materials = materials;
        this.descripcion = descripcion;
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
