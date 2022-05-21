package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.commands.AgregarImplemento;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.events.ImplementoAgregado;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.estudio.values.ImplementoId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarImplementoUseCaseTest {
    @InjectMocks
    private AgregarImplementoUseCase agregarImplementoUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarImplemento(){
        EstudioId estudioId = EstudioId.of("xxx");
        ImplementoId implementoId = ImplementoId.of("iii");
        Nombre nombre = new Nombre("Lazo");
        Descripcion descripcion = new Descripcion("Sirve para saltar");
        var command = new AgregarImplemento(estudioId, implementoId, nombre, descripcion);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarImplementoUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEstudioId().value())
                .syncExecutor(agregarImplementoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var implementoAgregado = (ImplementoAgregado) events.get(0);
        Assertions.assertEquals("xxx", implementoAgregado.aggregateRootId());
        Assertions.assertEquals("iii", implementoAgregado.getImplementoId().value());
        Assertions.assertEquals("Lazo", implementoAgregado.getNombre().value());
        Assertions.assertEquals("Sirve para saltar", implementoAgregado.getDescripcion().value());

    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Estudio Rutina superior");
        Descripcion descripcion = new Descripcion("resuelve esto y aquello");
        var event = new EstudioCreado(nombre, descripcion);
        event.setAggregateRootId("eee");
        return List.of(event);
    }
}