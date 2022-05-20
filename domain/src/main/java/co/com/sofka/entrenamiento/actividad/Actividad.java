package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.entrenamiento.actividad.events.ActividadCreada;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;
import co.com.sofka.entrenamiento.actividad.values.Instruccion;
import co.com.sofka.entrenamiento.actividad.values.Material;
import co.com.sofka.entrenamiento.actividad.values.Tiempo;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

import java.util.Set;

public class Actividad extends AggregateEvent<ActividadId> {
    protected Nombre nombre;
    protected Tiempo tiempo;
    protected Set<Material> materials;
    protected Instruccion instruccion;
    protected Descripcion descripcion;
    protected Set<Cliente> clientes;
    protected Entrenador entrenador;
    protected Set<Ejercicio> ejercicios;
    protected EstudioId estudioId;
    protected ProgramaId programaId;

    public Actividad(ActividadId actividadId, Nombre nombre, Tiempo tiempo, Set<Material> materials, Instruccion instruccion, Descripcion descripcion) {
        super(actividadId);
        appendChange(new ActividadCreada(nombre, tiempo, materials, instruccion, descripcion ));
    }
}
