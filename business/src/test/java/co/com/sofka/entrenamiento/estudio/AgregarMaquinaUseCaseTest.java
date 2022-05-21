package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.commands.AgregarMaquina;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.events.MaquinaAgregada;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.estudio.values.MaquinaId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarMaquinaUseCaseTest {

    @InjectMocks
    private AgregarMaquinaUseCase agregarMaquinaUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarMaquina() {
        EstudioId estudioId = EstudioId.of("xxx");
        MaquinaId maquinaId = MaquinaId.of("ooo");
        Nombre nombre = new Nombre("Barra alta");
        Descripcion descripcion = new Descripcion("Sirve para muchas cosas");
        var command = new AgregarMaquina(estudioId, maquinaId, nombre, descripcion);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarMaquinaUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEstudioId().value())
                .syncExecutor(agregarMaquinaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var maquinaAgregada = (MaquinaAgregada) events.get(0);
        Assertions.assertEquals("xxx", maquinaAgregada.aggregateRootId());
        Assertions.assertEquals("ooo", maquinaAgregada.getMaquinaId().value());
        Assertions.assertEquals("Barra alta", maquinaAgregada.getNombre().value());
        Assertions.assertEquals("Sirve para muchas cosas", maquinaAgregada.getDescripcion().value());


    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Estudio Rutina superior");
        Descripcion descripcion = new Descripcion("resuelve esto y aquello");
        var event = new EstudioCreado(nombre, descripcion);
        event.setAggregateRootId("eee");
        return List.of(event);
    }
}