package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.actividad.commands.AgregarEjercicio;

public class AgregarEjercicioUseCase extends UseCase<RequestCommand<AgregarEjercicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEjercicio> agregarEjercicioRequestCommand) {
        var command = agregarEjercicioRequestCommand.getCommand();

        var actividad = Actividad.from(
                command.getActividadId(),
                repository().getEventsBy(command.getActividadId().value())
        );
        actividad.agregarEjercicio(
                command.getEjercicioId(),
                command.getNombre(),
                command.getRonda(),
                command.getRepeticion(),
                command.getTiempo(),
                command.getMaterial(),
                command.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(actividad.getUncommittedChanges()));
    }
}
