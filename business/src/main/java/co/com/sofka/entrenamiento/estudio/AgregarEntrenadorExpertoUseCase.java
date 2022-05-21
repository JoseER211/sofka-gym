package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.estudio.commands.AgregarEntrenadorExperto;

public class AgregarEntrenadorExpertoUseCase extends UseCase<RequestCommand<AgregarEntrenadorExperto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEntrenadorExperto> agregarEntrenadorExpertoRequestCommand) {
        var command = agregarEntrenadorExpertoRequestCommand.getCommand();

        var estudio = Estudio.from(
                command.getEstudioId(),
                repository().getEventsBy(command.getEstudioId().value())
        );

        estudio.agregarEntrenadorExperto(
                command.getEntrenadorExpertoId(),
                command.getNombre(),
                command.getCelular(),
                command.getCorreo()
        );
        emit().onResponse(new ResponseEvents(estudio.getUncommittedChanges()));

    }
}
