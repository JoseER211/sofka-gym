package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.commands.AgregarEjercicio;
import co.com.sofka.entrenamiento.actividad.events.ActividadCreada;
import co.com.sofka.entrenamiento.actividad.events.EjercicioAgregado;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEjercicioUseCaseTest {
    @InjectMocks
    private AgregarEjercicioUseCase agregarEjercicioUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarEjercicio() {
        ActividadId actividadId = ActividadId.of("xxx");
        EjercicioId ejercicioId = EjercicioId.of("ttt");
        Nombre nombre = new Nombre("Dominada");
        Ronda ronda = new Ronda(3);
        Repeticion repeticion = new Repeticion(10);
        Tiempo tiempo = new Tiempo(LocalTime.of(0, 30));
        Material material = new Material("Barra");
        Descripcion descripcion = new Descripcion("Sirve para esto y aquello");
        var command = new AgregarEjercicio(actividadId, ejercicioId, nombre, ronda, repeticion, tiempo, material, descripcion);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarEjercicioUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getActividadId().value())
                .syncExecutor(agregarEjercicioUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var ejercicioAgregado = (EjercicioAgregado) events.get(0);
        Assertions.assertEquals("xxx", ejercicioAgregado.aggregateRootId());
        Assertions.assertEquals("ttt", ejercicioAgregado.getEjercicioId().value());
        Assertions.assertEquals("Dominada", ejercicioAgregado.getNombre().value());
        Assertions.assertEquals(3, ejercicioAgregado.getRonda().value());
        Assertions.assertEquals(10, ejercicioAgregado.getRepeticion().value());
        Assertions.assertEquals(LocalTime.of(0, 30), ejercicioAgregado.getTiempo().value());
        Assertions.assertEquals("Barra", ejercicioAgregado.getMaterial().value());
        Assertions.assertEquals("Sirve para esto y aquello", ejercicioAgregado.getDescripcion().value());
    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Entrena el tren superior");
        Tiempo tiempo = new Tiempo(LocalTime.of(11, 51));
        Material material = new Material("Pesas");
        Instruccion instruccion = new Instruccion("Se hace así y asá");
        Descripcion descripcion = new Descripcion("Esta actividad sirve para esto y aquello");
        var event = new ActividadCreada(nombre, tiempo, material, instruccion, descripcion);
        event.setAggregateRootId("nnn");
        return List.of(event);
    }
}