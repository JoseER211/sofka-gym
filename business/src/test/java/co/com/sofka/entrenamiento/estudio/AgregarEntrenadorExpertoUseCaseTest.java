package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.estudio.commands.AgregarEntrenadorExperto;
import co.com.sofka.entrenamiento.estudio.events.EntrenadorExpertoAgregado;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.values.EntrenadorExpertoId;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
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

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEntrenadorExpertoUseCaseTest {
    @InjectMocks
    private AgregarEntrenadorExpertoUseCase agregarEntrenadorExpertoUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarEntrenadorExperto() {
        EstudioId estudioId = EstudioId.of("xxx");
        EntrenadorExpertoId entrenadorExpertoId = EntrenadorExpertoId.of("mmm");
        Nombre nombre = new Nombre("Mauro");
        Celular celular = new Celular(12345678);
        Correo correo = new Correo("Mauro@gmail.com");
        var command = new AgregarEntrenadorExperto(estudioId, entrenadorExpertoId, nombre, celular, correo);

        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarEntrenadorExpertoUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEstudioId().value())
                .syncExecutor(agregarEntrenadorExpertoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var entrenadorExpertoAgregado = (EntrenadorExpertoAgregado) events.get(0);
        Assertions.assertEquals("xxx", entrenadorExpertoAgregado.aggregateRootId());
        Assertions.assertEquals("mmm", entrenadorExpertoAgregado.getEntrenadorExpertoId().value());
        Assertions.assertEquals("Mauro", entrenadorExpertoAgregado.getNombre().value());
        Assertions.assertEquals(12345678, entrenadorExpertoAgregado.getCelular().value());
        Assertions.assertEquals("Mauro@gmail.com", entrenadorExpertoAgregado.getCorreo().value());
    }


    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("Estudio Rutina superior");
        Descripcion descripcion = new Descripcion("resuelve esto y aquello");
        var event = new EstudioCreado(nombre, descripcion);
        event.setAggregateRootId("eee");
        return List.of(event);
    }
}