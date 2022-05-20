package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.programa.commands.CrearPrograma;

public class CrearProgramaUseCase extends UseCase<RequestCommand<CrearPrograma>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPrograma> crearProgramaRequestCommand) {
        var command = crearProgramaRequestCommand.getCommand();
        var programa = new Programa(
                command.getProgramaId(),
                command.getNombre(),
                command.getValoracion()
        );
        emit().onResponse(new ResponseEvents(programa.getUncommittedChanges()));
    }
}
