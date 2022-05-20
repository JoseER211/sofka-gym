package co.com.sofka.entrenamiento.programa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
import co.com.sofka.entrenamiento.programa.values.NutricionistaId;
import co.com.sofka.entrenamiento.programa.values.ProgramaId;

public class AgregarNutricionista extends Command {
    private final ProgramaId programaId;
    private final NutricionistaId nutricionistaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final NumeroConsultorio numeroConsultorio;

    public AgregarNutricionista(ProgramaId programaId, NutricionistaId nutricionistaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        this.programaId = programaId;
        this.nutricionistaId = nutricionistaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }

    public NutricionistaId getNutricionistaId() {
        return nutricionistaId;
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
