package co.com.sofka.entrenamiento.programa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.FisioterapeutaId;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

public class AgregarFisioterapeuta extends Command {
    private final ProgramaId programaId;
    private final FisioterapeutaId fisioterapeutaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final NumeroConsultorio numeroConsultorio;

    public AgregarFisioterapeuta(ProgramaId programaId, FisioterapeutaId fisioterapeutaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        this.programaId = programaId;
        this.fisioterapeutaId = fisioterapeutaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }

    public FisioterapeutaId getFisioterapeutaId() {
        return fisioterapeutaId;
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

    public NumeroConsultorio getNumeroConsultorio() {
        return numeroConsultorio;
    }
}
