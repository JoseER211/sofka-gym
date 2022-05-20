package co.com.sofka.entrenamiento.actividad.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;
import co.com.sofka.entrenamiento.actividad.values.Instruccion;
import co.com.sofka.entrenamiento.actividad.values.Material;
import co.com.sofka.entrenamiento.actividad.values.Tiempo;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

import java.util.Set;

public class CrearActividad extends Command {
    private final ActividadId actividadId;
    private final Nombre nombre;
    private final Tiempo tiempo;
    private final Material material;
    private final Instruccion instruccion;
    private final Descripcion descripcion;

    public CrearActividad(ActividadId actividadId, Nombre nombre, Tiempo tiempo, Material material, Instruccion instruccion, Descripcion descripcion) {
        this.actividadId = actividadId;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.material = material;
        this.instruccion = instruccion;
        this.descripcion = descripcion;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public Material getMaterial() {
        return material;
    }

    public Instruccion getInstruccion() {
        return instruccion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
