package co.com.sofka.entrenamiento.programa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.MaestroDeYogaId;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

public class AgregarMaestroDeYoga extends Command {
    private final ProgramaId programaId;
    private final MaestroDeYogaId maestroDeYogaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;

    public AgregarMaestroDeYoga(ProgramaId programaId, MaestroDeYogaId maestroDeYogaId, Nombre nombre, Celular celular, Correo correo) {
        this.programaId = programaId;
        this.maestroDeYogaId = maestroDeYogaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }

    public MaestroDeYogaId getMaestroDeYogaId() {
        return maestroDeYogaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public Correo getCorreo() {
        return correo;
    }
}
