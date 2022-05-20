package co.com.sofka.entrenamiento.programa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;
import co.com.sofka.entrenamiento.programa.values.NutricionistaId;

public class Nutricionista extends Entity<NutricionistaId> {
    private Nombre nombre;
    private Celular celular;
    private Correo correo;
    private NumeroConsultorio numeroConsultorio;

    public Nutricionista(NutricionistaId nutricionistaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        super(nutricionistaId);
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
    }

    public void cambiarInformacion(Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
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
