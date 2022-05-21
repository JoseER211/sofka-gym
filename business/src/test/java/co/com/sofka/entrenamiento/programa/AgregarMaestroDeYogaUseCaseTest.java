package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.commands.AgregarMaestroDeYoga;
import co.com.sofka.entrenamiento.programa.events.MaestroDeYogaAgregado;
import co.com.sofka.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofka.entrenamiento.programa.values.MaestroDeYogaId;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;
import co.com.sofka.entrenamiento.programa.values.Valoracion;
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
class AgregarMaestroDeYogaUseCaseTest {
    @InjectMocks
    private AgregarMaestroDeYogaUseCase agregarMaestroDeYogaUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarMaestroDeYoga(){
        ProgramaId programaId = ProgramaId.of("xxx");
        MaestroDeYogaId maestroDeYogaId = MaestroDeYogaId.of("zzz");
        Nombre nombre = new Nombre("Alejo");
        Celular celular = new Celular(12345678);
        Correo correo = new Correo("Alejo@gmail.com");
        var command = new AgregarMaestroDeYoga(programaId, maestroDeYogaId, nombre, celular, correo);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarMaestroDeYogaUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMaestroDeYogaId().value())
                .syncExecutor(agregarMaestroDeYogaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var maestroDeYogaAgregado = (MaestroDeYogaAgregado) events.get(0);
        Assertions.assertEquals("xxx", maestroDeYogaAgregado.aggregateRootId());
        Assertions.assertEquals("zzz", maestroDeYogaAgregado.getMaestroDeYogaId().value());
        Assertions.assertEquals("Alejo", maestroDeYogaAgregado.getNombre().value());
        Assertions.assertEquals(12345678, maestroDeYogaAgregado.getCelular().value());
        Assertions.assertEquals("Alejo@gmail.com", maestroDeYogaAgregado.getCorreo().value());

    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Entrenamiento de fuerza");
        Valoracion valoracion = new Valoracion(4.8);
        var event = new ProgramaCreado(nombre, valoracion);
        event.setAggregateRootId("ppp");
        return List.of(event);
    }
}