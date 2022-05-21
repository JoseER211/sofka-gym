package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.entrenamiento.estudio.commands.CrearEstudio;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.values.EstudioId;
import co.com.sofka.entrenamiento.generalValues.Descripcion;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEstudioUseCaseTest {

    private CrearEstudioUseCase crearEstudioUseCase;

    @BeforeEach
    void setUp() {
        crearEstudioUseCase = new CrearEstudioUseCase();
    }

    @Test
    public void crearEstudio() {
        EstudioId estudioId = EstudioId.of("eee");
        Nombre nombre = new Nombre("Estudio Rutina superior");
        Descripcion descripcion = new Descripcion("resuelve esto y aquello");

        var command = new CrearEstudio(estudioId, nombre, descripcion);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearEstudioUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var estudioCreado = (EstudioCreado) events.get(0);
        Assertions.assertEquals("eee", estudioCreado.aggregateRootId());
        Assertions.assertEquals("Estudio Rutina superior", estudioCreado.getNombre().value());
        Assertions.assertEquals("resuelve esto y aquello", estudioCreado.getDescripcion().value());

    }
}