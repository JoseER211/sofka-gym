package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.entrenamiento.actividad.commands.CrearActividad;
import co.com.sofka.entrenamiento.actividad.events.ActividadCreada;
import co.com.sofka.entrenamiento.actividad.values.ActividadId;
import co.com.sofka.entrenamiento.actividad.values.Instruccion;
import co.com.sofka.entrenamiento.actividad.values.Material;
import co.com.sofka.entrenamiento.actividad.values.Tiempo;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

class CrearActividadUseCaseTest {

    private CrearActividadUseCase crearActividadUseCase;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        crearActividadUseCase = new CrearActividadUseCase();
    }

    @Test
    public void crearActividad(){
        ActividadId actividadId = ActividadId.of("nnn");
        Nombre nombre = new Nombre("Entrena el tren superior");
        Tiempo tiempo = new Tiempo(LocalTime.of(11,51));
        Set<Material> materials = new HashSet<>();
        materials.add(new Material("Pesas"));
        Instruccion instruccion = new Instruccion("Se hace así y asá");
        Descripcion descripcion = new Descripcion("Esta actividad sirve para esto y aquello");

        var command = new CrearActividad(actividadId, nombre, tiempo, materials, instruccion, descripcion);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearActividadUseCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        var actividadCreada = (ActividadCreada) events.get(0);
        Assertions.assertEquals("nnn", actividadCreada.aggregateRootId());
        Assertions.assertEquals("Entrena el tren superior", actividadCreada.getNombre().value());
        Assertions.assertEquals(LocalTime.of(11,51), actividadCreada.getTiempo().value());
        Assertions.assertEquals(materials, actividadCreada.getMaterials());
        Assertions.assertEquals("Se hace así y asá", actividadCreada.getInstruccion().value());
        Assertions.assertEquals("Esta actividad sirve para esto y aquello", actividadCreada.getDescripcion().value());


    }
}