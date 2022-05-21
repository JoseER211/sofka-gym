package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.programa.commands.AgregarMaestroDeYoga;

public class AgregarMaestroDeYogaUseCase extends UseCase<RequestCommand<AgregarMaestroDeYoga>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMaestroDeYoga> agregarMaestroDeYogaRequestCommand) {
        var command = agregarMaestroDeYogaRequestCommand.getCommand();

        var programa = Programa.from(
                command.getProgramaId(),
                repository().getEventsBy(command.getProgramaId().value())
        );

        programa.agregarMaestroDeYoga(
                command.getMaestroDeYogaId(),
                command.getNombre(),
                command.getCelular(),
                command.getCorreo()
        );
        emit().onResponse(new ResponseEvents(programa.getUncommittedChanges()));
    }
}
