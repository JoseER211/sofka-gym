package co.com.sofka.entrenamiento.programa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.entrenamiento.programa.commands.AgregarNutricionista;

public class AgregarNutricionistaUseCase extends UseCase<RequestCommand<AgregarNutricionista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarNutricionista> agregarNutricionistaRequestCommand) {
        var command = agregarNutricionistaRequestCommand.getCommand();

        var programa = Programa.from(
                command.getProgramaId(),
                repository().getEventsBy(command.getProgramaId().value())
        );

        programa.agregarNutricionista(
                command.getNutricionistaId(),
                command.getNombre(),
                command.getCelular(),
                command.getCorreo(),
                command.getNumeroConsultorio()
        );
        emit().onResponse(new ResponseEvents(programa.getUncommittedChanges()));
    }
}
