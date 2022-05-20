package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.events.*;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

import java.util.List;
import java.util.Set;

public class Actividad extends AggregateEvent<ActividadId> {
    protected Nombre nombre;
    protected Tiempo tiempo;
    protected Material material;
    protected Instruccion instruccion;
    protected Descripcion descripcion;
    protected Set<Cliente> clientes;
    protected Entrenador entrenador;
    protected Set<Ejercicio> ejercicios;
    protected EstudioId estudioId;
    protected ProgramaId programaId;

    public Actividad(ActividadId actividadId, Nombre nombre, Tiempo tiempo, Material material, Instruccion instruccion, Descripcion descripcion) {
        super(actividadId);
        appendChange(new ActividadCreada(nombre, tiempo, material, instruccion, descripcion ));
    }

    private Actividad(ActividadId actividadId){
        super(actividadId);
        subscribe(new ActividadChange(this));
    }

    public static Actividad from(ActividadId actividadId, List<DomainEvent> events){
        var actividad = new Actividad(actividadId);
        events.forEach(actividad::applyEvent);
        return actividad;
    }

    public void agregarCliente(ClienteId clienteId, Identificacion identificacion, Nombre nombre, Edad edad, EPS eps){
        appendChange(new ClienteAgregado(clienteId, identificacion, nombre, edad, eps)).apply();
    }

    public void agregarEntrenador(EntrenadorId entrenadorId, Nombre nombre, Celular celular, Correo correo){
        appendChange(new EntrenadorAgregado(entrenadorId, nombre, celular, correo)).apply();
    }
    public void agregarEjercicio(EjercicioId ejercicioId, Nombre nombre, Ronda ronda, Repeticion repeticion, Tiempo tiempo, Set<Material> materials, Descripcion descripcion){
        appendChange(new EjercicioAgregado(ejercicioId, nombre, ronda, repeticion, tiempo, materials, descripcion)).apply();
    }

    public void asociarEstudio(EstudioId estudioId){
        appendChange(new EstudioAsociado(estudioId)).apply();
    }

    public void asociarPrograma(ProgramaId programaId){
        appendChange(new ProgramaAsociado(programaId)).apply();
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

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Set<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public EstudioId getEstudioId() {
        return estudioId;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
