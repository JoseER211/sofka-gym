package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.commands.AgregarCliente;
import co.com.sofka.entrenamiento.actividad.events.ActividadCreada;
import co.com.sofka.entrenamiento.actividad.events.ClienteAgregado;
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
class AgregarClienteUseCaseTest {
    @InjectMocks
    private AgregarClienteUseCase agregarClienteUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarCliente() {
        ActividadId actividadId = ActividadId.of("xxx");
        ClienteId clienteId = ClienteId.of("ccc");
        Identificacion identificacion = new Identificacion(4);
        Nombre nombre = new Nombre("Pepito");
        Edad edad = new Edad(28);
        EPS eps = new EPS("SURA");
        var command = new AgregarCliente(actividadId, clienteId, identificacion, nombre, edad, eps);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarClienteUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getActividadId().value())
                .syncExecutor(agregarClienteUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var clienteAgregado = (ClienteAgregado) events.get(0);
        Assertions.assertEquals("xxx", clienteAgregado.aggregateRootId());
        Assertions.assertEquals("ccc", clienteAgregado.getClienteId().value());
        Assertions.assertEquals(4, clienteAgregado.getIdentificacion().value());
        Assertions.assertEquals("Pepito", clienteAgregado.getNombre().value());
        Assertions.assertEquals(28, clienteAgregado.getEdad().value());
        Assertions.assertEquals("SURA", clienteAgregado.getEps().value());
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