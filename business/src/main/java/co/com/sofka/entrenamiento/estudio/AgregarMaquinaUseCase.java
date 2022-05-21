package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.estudio.commands.AgregarMaquina;

public class AgregarMaquinaUseCase extends UseCase<RequestCommand<AgregarMaquina>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMaquina> agregarMaquinaRequestCommand) {
        var command = agregarMaquinaRequestCommand.getCommand();

        var estduio = Estudio.from(
                command.getEstudioId(),
                repository().getEventsBy(command.getEstudioId().value())
        );

        estduio.agregarMaquina(
                command.getMaquinaId(),
                command.getNombre(),
                command.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(estduio.getUncommittedChanges()));
    }
}
