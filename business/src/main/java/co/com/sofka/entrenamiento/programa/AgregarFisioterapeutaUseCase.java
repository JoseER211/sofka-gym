package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.programa.commands.AgregarFisioterapeuta;

public class AgregarFisioterapeutaUseCase extends UseCase<RequestCommand<AgregarFisioterapeuta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFisioterapeuta> agregarFisioterapeutaRequestCommand) {
        var command = agregarFisioterapeutaRequestCommand.getCommand();

        var programa = Programa.from(
                command.getProgramaId(),
                repository().getEventsBy(command.getProgramaId().value())
        );
        programa.agregarFisioterapeuta(

                command.getFisioterapeutaId(),
                command.getNombre(),
                command.getCelular(),
                command.getCorreo(),
                command.getNumeroConsultorio()
        );
        emit().onResponse(new ResponseEvents(programa.getUncommittedChanges()));
    }

}
