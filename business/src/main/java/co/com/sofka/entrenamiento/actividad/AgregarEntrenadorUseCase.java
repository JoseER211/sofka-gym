package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.actividad.commands.AgregarEntrenador;

public class AgregarEntrenadorUseCase extends UseCase<RequestCommand<AgregarEntrenador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEntrenador> agregarEntrenadorRequestCommand) {
        var command = agregarEntrenadorRequestCommand.getCommand();

        var actividad = Actividad.from(
                command.getActividadId(),
                repository().getEventsBy(command.getActividadId().value())
        );
        actividad.agregarEntrenador(
                command.getEntrenadorId(),
                command.getNombre(),
                command.getCelular(),
                command.getCorreo()
        );
        emit().onResponse(new ResponseEvents(actividad.getUncommittedChanges()));
    }
}
