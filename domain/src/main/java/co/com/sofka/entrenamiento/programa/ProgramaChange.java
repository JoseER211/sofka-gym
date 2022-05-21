package co.com.sofka.entrenamiento.programa;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.entrenamiento.programa.events.*;

public class ProgramaChange extends EventChange {

    public ProgramaChange(Programa programa) {
        apply((ProgramaCreado event) -> {
            programa.nombre = event.getNombre();
            programa.valoracion = event.getValoracion();

        });

        apply((FisioterapeutaAgregado event) ->
                programa.fisioterapeuta = new Fisioterapeuta(
                        event.getFisioterapeutaId(),
                        event.getNombre(),
                        event.getCelular(),
                        event.getCorreo(),
                        event.getNumeroConsultorio()
                ));

        apply((MaestroDeYogaAgregado event) -> programa.maestroDeYoga = new MaestroDeYoga(
                event.getMaestroDeYogaId(),
                event.getNombre(),
                event.getCelular(),
                event.getCorreo()
        ));

        apply((NutricionistaAgregado event) ->
                programa.nutricionista = new Nutricionista(
                        event.getNutricionistaId(),
                        event.getNombre(),
                        event.getCelular(),
                        event.getCorreo(),
                        event.getNumeroConsultorio()
                ));



    }
}
