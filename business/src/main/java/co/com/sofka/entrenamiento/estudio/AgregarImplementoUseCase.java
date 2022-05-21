package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.estudio.commands.AgregarImplemento;

public class AgregarImplementoUseCase extends UseCase<RequestCommand<AgregarImplemento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarImplemento> agregarImplementoRequestCommand) {
        var command = agregarImplementoRequestCommand.getCommand();

        var estudio = Estudio.from(
                command.getEstudioId(),
                repository().getEventsBy(command.getEstudioId().value())
        );

        estudio.agregarImplemento(
                command.getImplementoId(),
                command.getNombre(),
                command.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(estudio.getUncommittedChanges()));
    }
}
