package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.commands.AgregarNutricionista;
import co.com.sofka.entrenamiento.programa.events.NutricionistaAgregado;
import co.com.sofka.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
import co.com.sofka.entrenamiento.programa.values.NutricionistaId;
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
class AgregarNutricionistaUseCaseTest {
    @InjectMocks
    private AgregarNutricionistaUseCase agregarNutricionistaUseCase;

    @Mock
    private DomainEventRepository domainEventRepository;

    @Test
    public void agregarNutricionista(){
        ProgramaId programaId = ProgramaId.of("xxx");
        NutricionistaId nutricionistaId = NutricionistaId.of("ggg");
        Nombre nombre = new Nombre("Olaf");
        Celular celular = new Celular(12345678);
        Correo correo = new Correo("Olaf@gmail.com");
        NumeroConsultorio numeroConsultorio = new NumeroConsultorio(2);
        var command = new AgregarNutricionista(programaId, nutricionistaId, nombre, celular, correo, numeroConsultorio);


        when(domainEventRepository.getEventsBy("xxx")).thenReturn(history());
        agregarNutricionistaUseCase.addRepository(domainEventRepository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getNutricionistaId().value())
                .syncExecutor(agregarNutricionistaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var nutricionistaAgregado = (NutricionistaAgregado) events.get(0);
        Assertions.assertEquals("xxx", nutricionistaAgregado.aggregateRootId());
        Assertions.assertEquals("ggg", nutricionistaAgregado.getNutricionistaId().value());
        Assertions.assertEquals("Olaf", nutricionistaAgregado.getNombre().value());
        Assertions.assertEquals(12345678, nutricionistaAgregado.getCelular().value());
        Assertions.assertEquals("Olaf@gmail.com", nutricionistaAgregado.getCorreo().value());
        Assertions.assertEquals(2, nutricionistaAgregado.getNumeroConsultorio().value());
    }


    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Entrenamiento de fuerza");
        Valoracion valoracion = new Valoracion(4.8);
        var event = new ProgramaCreado(nombre, valoracion);
        event.setAggregateRootId("ppp");
        return List.of(event);
    }
}