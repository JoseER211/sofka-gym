package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.entrenamiento.actividad.events.*;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;

import java.util.HashSet;

public class ActividadChange extends EventChange {

    public ActividadChange(Actividad actividad) {
        apply((ActividadCreada event) -> {
            actividad.nombre = event.getNombre();
            actividad.tiempo = event.getTiempo();
            actividad.material = event.getMaterial();
            actividad.instruccion = event.getInstruccion();
            actividad.descripcion = event.getDescripcion();
        });

        apply((ClienteAgregado event) ->
                actividad.clientes.add(new Cliente(
                        event.getClienteId(),
                        event.getIdentificacion(),
                        event.getNombre(),
                        event.getEdad(),
                        event.getEps()))
        );
        apply((EntrenadorAgregado event) ->
                actividad.entrenador = new Entrenador(
                        event.getEntrenadorId(),
                        event.getNombre(),
                        event.getCelular(),
                        event.getCorreo())
        );

        apply((EjercicioAgregado event) ->
                actividad.ejercicios.add(new Ejercicio(
                        event.getEjercicioId(),
                        event.getNombre(),
                        event.getRonda(),
                        event.getRepeticion(),
                        event.getTiempo(),
                        event.getMaterials(),
                        event.getDescripcion()))
        );

        apply((EstudioAsociado event) ->
                actividad.estudioId = event.getEstudioId()
        );

        apply((ProgramaAsociado event) ->
                actividad.programaId = event.getProgramaId()
        );
    }

}
