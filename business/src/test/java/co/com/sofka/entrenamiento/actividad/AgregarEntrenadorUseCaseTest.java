package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.commands.AgregarEntrenador;
import co.com.sofka.entrenamiento.actividad.events.ActividadCreada;
import co.com.sofka.entrenamiento.actividad.events.EntrenadorAgregado;
import co.com.sofka.entrenamiento.actividad.values.*;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEntrenadorUseCaseTest {
    @InjectMocks
    private AgregarEntrenadorUseCase agregarEntrenadorUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarEntrenador(){
        ActividadId actividadId = ActividadId.of("xxx");
        EntrenadorId entrenadorId = EntrenadorId.of("eee");
        Nombre nombre = new Nombre("Rodolfo");
        Celular celular = new Celular(12345678);
        Correo correo = new Correo("Rodolfo@gmail.com");
        var command = new AgregarEntrenador(actividadId, entrenadorId, nombre, celular, correo);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarEntrenadorUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getActividadId().value())
                .syncExecutor(agregarEntrenadorUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var entrenadorAgregado = (EntrenadorAgregado) events.get(0);
        Assertions.assertEquals("xxx", entrenadorAgregado.aggregateRootId());
        Assertions.assertEquals("eee", entrenadorAgregado.getEntrenadorId().value());
        Assertions.assertEquals("Rodolfo", entrenadorAgregado.getNombre().value());
        Assertions.assertEquals(12345678, entrenadorAgregado.getCelular().value());
        Assertions.assertEquals("Rodolfo@gmail.com", entrenadorAgregado.getCorreo().value());

    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Entrena el tren superior");
        Tiempo tiempo = new Tiempo(LocalTime.of(11,51));
        Material material = new Material("Pesas");
        Instruccion instruccion = new Instruccion("Se hace así y asá");
        Descripcion descripcion = new Descripcion("Esta actividad sirve para esto y aquello");
        var event = new ActividadCreada(nombre, tiempo, material, instruccion, descripcion);
        event.setAggregateRootId("nnn");
        return List.of(event);
    }
}