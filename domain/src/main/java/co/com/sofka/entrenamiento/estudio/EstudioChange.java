package co.com.sofka.entrenamiento.estudio;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.entrenamiento.estudio.events.EntrenadorExpertoAgregado;
import co.com.sofka.entrenamiento.estudio.events.EstudioCreado;
import co.com.sofka.entrenamiento.estudio.events.ImplementoAgregado;
import co.com.sofka.entrenamiento.estudio.events.MaquinaAgregada;

public class EstudioChange extends EventChange {

    public EstudioChange(Estudio estudio) {

        apply((EstudioCreado event) ->{
            estudio.nombre = event.getNombre();
            estudio.descripcion = event.getDescripcion();
        });

        apply((EntrenadorExpertoAgregado event) -> estudio.entrenadorExperto = new EntrenadorExperto(
                event.getEntrenadorExpertoId(),
                event.getNombre(),
                event.getCelular(),
                event.getCorreo()
        ));

        apply((ImplementoAgregado event) ->
                estudio.implementos.add(new Implemento(event.getImplementoId(), event.getNombre(),event.getDescripcion())));

        apply((MaquinaAgregada event) ->
                estudio.maquinas.add(new Maquina(event.getMaquinaId(), event.getNombre(),event.getDescripcion())));
    }
}
