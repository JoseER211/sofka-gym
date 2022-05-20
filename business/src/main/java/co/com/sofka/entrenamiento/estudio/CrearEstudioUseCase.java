package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.estudio.commands.CrearEstudio;

public class CrearEstudioUseCase extends UseCase<RequestCommand<CrearEstudio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEstudio> crearEstudioRequestCommand) {
        var command = crearEstudioRequestCommand.getCommand();
        var estudio = new Estudio(
                command.getEstudioId(),
                command.getNombre(),
                command.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(estudio.getUncommittedChanges()));
    }
}
