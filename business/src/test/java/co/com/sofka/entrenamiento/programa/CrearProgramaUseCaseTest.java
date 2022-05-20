package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.commands.CrearPrograma;
import co.com.sofka.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;
import co.com.sofka.entrenamiento.programa.values.Valoracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

class CrearProgramaUseCaseTest {

    private CrearProgramaUseCase crearProgramaUseCase;
    @BeforeEach
    void setUp() {
        crearProgramaUseCase = new CrearProgramaUseCase();
    }

    @Test
    public void crearPrograma(){
        ProgramaId programaId = ProgramaId.of("ppp");
        Nombre nombre = new Nombre("Entrenamiento de fuerza");
        Valoracion valoracion = new Valoracion(4.8);

        var command = new CrearPrograma(programaId, nombre, valoracion);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearProgramaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var programaCreado = (ProgramaCreado) events.get(0);
        Assertions.assertEquals("ppp", programaCreado.aggregateRootId());
        Assertions.assertEquals("Entrenamiento de fuerza", programaCreado.getNombre().value());
        Assertions.assertEquals(4.8, programaCreado.getValoracion().value());
    }

}