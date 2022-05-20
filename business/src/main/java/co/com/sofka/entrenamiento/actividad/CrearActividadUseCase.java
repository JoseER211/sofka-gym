package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.actividad.commands.CrearActividad;

public class CrearActividadUseCase extends UseCase<RequestCommand<CrearActividad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearActividad> crearActividadRequestCommand) {
        var command = crearActividadRequestCommand.getCommand();

        var actividad = new Actividad(
                command.getActividadId(),
                command.getNombre(),
                command.getTiempo(),
                command.getMaterial(),
                command.getInstruccion(),
                command.getDescripcion());

        emit().onResponse(new ResponseEvents(actividad.getUncommittedChanges()));
    }
}
