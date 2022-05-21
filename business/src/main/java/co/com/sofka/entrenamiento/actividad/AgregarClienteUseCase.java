package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.actividad.commands.AgregarCliente;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();

        var actividad = Actividad.from(
                command.getActividadId(),
                repository().getEventsBy(command.getActividadId().value())
        );
        actividad.agregarCliente(
                command.getClienteId(),
                command.getIdentificacion(),
                command.getNombre(),
                command.getEdad(),
                command.getEps());
        emit().onResponse(new ResponseEvents(actividad.getUncommittedChanges()));
    }
}
