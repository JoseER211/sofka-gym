package co.com.sofka.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
import co.com.sofka.entrenamiento.programa.values.NutricionistaId;

public class NutricionistaAgregado extends DomainEvent {
    private final NutricionistaId nutricionistaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final NumeroConsultorio numeroConsultorio;

    public NutricionistaAgregado(NutricionistaId nutricionistaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        super("sofka.programa.nutricionistaagregado");
        this.nutricionistaId = nutricionistaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
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
