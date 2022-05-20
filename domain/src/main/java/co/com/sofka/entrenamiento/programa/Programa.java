package co.com.sofka.entrenamiento.programa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.generalValues.Celular;
import co.com.sofka.entrenamiento.generalValues.Correo;
import co.com.sofka.entrenamiento.generalValues.Nombre;
import co.com.sofka.entrenamiento.programa.events.*;
import co.com.sofka.entrenamiento.programa.values.*;

import java.util.List;

public class Programa extends AggregateEvent<ProgramaId> {
    protected Nombre nombre;
    protected Valoracion valoracion;
    protected Fisioterapeuta fisioterapeuta;
    protected MaestroDeYoga maestroDeYoga;
    protected Nutricionista nutricionista;

    public Programa(ProgramaId programaId, Nombre nombre, Valoracion valoracion) {
        super(programaId);
        appendChange(new ProgramaCreado(nombre, valoracion));
    }

    private Programa(ProgramaId programaId){
        super(programaId);
        subscribe(new ProgramaChange(this));
    }

    public static Programa from(ProgramaId programaId, List<DomainEvent> events){
        var programa = new Programa(programaId);
        events.forEach(programa::applyEvent);
        return programa;

    }

    public void agregarFisioterapeuta(FisioterapeutaId fisioterapeutaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio){
        appendChange(new FisioterapeutaAgregado(fisioterapeutaId, nombre, celular, correo, numeroConsultorio)).apply();
    }

    public void agregarMaestroDeYoga(MaestroDeYogaId maestroDeYogaId, Nombre nombre, Celular celular, Correo correo){
        appendChange(new MaestroDeYogaAgregado(maestroDeYogaId, nombre, celular, correo)).apply();
    }

    public void agregarNutricionista(NutricionistaId nutricionistaId, Nombre nombre, Celular celular, Correo correo, NumeroConsultorio numeroConsultorio){
        appendChange(new NutricionistaAgregado(nutricionistaId, nombre, celular, correo, numeroConsultorio)).apply();
    }

    public void actualizarValoracion(Valoracion valoracion){
        appendChange(new ValoracionActualizada(valoracion)).apply();
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public Fisioterapeuta getFisioterapeuta() {
        return fisioterapeuta;
    }

    public MaestroDeYoga getMaestroDeYoga() {
        return maestroDeYoga;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }
}
