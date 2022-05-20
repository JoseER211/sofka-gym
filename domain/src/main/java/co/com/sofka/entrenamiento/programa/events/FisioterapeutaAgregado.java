package co.com.sofka.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.values.FisioterapeutaId;
import co.com.sofka.entrenamiento.programa.values.NumeroConsultorio;

public class FisioterapeutaAgregado extends DomainEvent {
    private final FisioterapeutaId fisioterapeutaId;
    private final Nombre nombre;
    private final Celular celular;
    private final Correo correo;
    private final NumeroConsultorio numeroConsultorio;

    public FisioterapeutaAgregado(FisioterapeutaId fisioterapeutaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio) {
        super("sofka.programa.fisioterapeutaagregado");
        this.fisioterapeutaId = fisioterapeutaId;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.numeroConsultorio = numeroConsultorio;
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
