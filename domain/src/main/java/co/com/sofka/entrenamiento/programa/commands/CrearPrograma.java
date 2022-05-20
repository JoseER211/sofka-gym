package co.com.sofka.entrenamiento.programa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;
import co.com.sofka.entrenamiento.programa.values.Valoracion;

public class CrearPrograma extends Command {
    private final ProgramaId programaId;
    private final Nombre nombre;
    private final Valoracion valoracion;

    public CrearPrograma(ProgramaId programaId, Nombre nombre, Valoracion valoracion) {
        this.programaId = programaId;
        this.nombre = nombre;
        this.valoracion = valoracion;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }
}
