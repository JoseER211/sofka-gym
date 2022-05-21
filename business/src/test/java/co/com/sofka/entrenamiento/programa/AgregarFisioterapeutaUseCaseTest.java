package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.commands.AgregarFisioterapeuta;
import co.com.sofka.entrenamiento.programa.events.FisioterapeutaAgregado;
import co.com.sofka.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofka.entrenamiento.programa.values.FisioterapeutaId;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
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
class AgregarFisioterapeutaUseCaseTest {
    @InjectMocks
    private AgregarFisioterapeutaUseCase agregarFisioterapeutaUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarFisioterapeuta(){
        ProgramaId programaId = ProgramaId.of("xxx");
        FisioterapeutaId fisioterapeutaId = FisioterapeutaId.of("fff");
        Nombre nombre = new Nombre("Alfonso");
        Celular celular = new Celular(12345678);
        Correo correo = new Correo("Alfonso@gmail.com");
        NumeroConsultorio numeroConsultorio = new NumeroConsultorio(1);
        var command = new AgregarFisioterapeuta(programaId, fisioterapeutaId, nombre, celular, correo, numeroConsultorio);


        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarFisioterapeutaUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFisioterapeutaId().value())
                .syncExecutor(agregarFisioterapeutaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var fisioterapeutaAgregado = (FisioterapeutaAgregado) events.get(0);
        Assertions.assertEquals("xxx", fisioterapeutaAgregado.aggregateRootId());
        Assertions.assertEquals("fff", fisioterapeutaAgregado.getFisioterapeutaId().value());
        Assertions.assertEquals("Alfonso", fisioterapeutaAgregado.getNombre().value());
        Assertions.assertEquals(12345678, fisioterapeutaAgregado.getCelular().value());
        Assertions.assertEquals("Alfonso@gmail.com", fisioterapeutaAgregado.getCorreo().value());
        Assertions.assertEquals(1, fisioterapeutaAgregado.getNumeroConsultorio().value());
    }
    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Entrenamiento de fuerza");
        Valoracion valoracion = new Valoracion(4.8);
        var event = new ProgramaCreado(nombre, valoracion);
        event.setAggregateRootId("ppp");
        return List.of(event);
    }
}