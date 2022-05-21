package co.com.sofka.entrenamiento.actividad;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.entrenamiento.actividad.values.ClienteId;
import co.com.sofka.entrenamiento.actividad.values.EPS;
import co.com.sofka.entrenamiento.actividad.values.Edad;
import co.com.sofka.entrenamiento.actividad.values.Identificacion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class Cliente extends Entity<ClienteId> {
    private Identificacion identificacion;
    private Nombre nombre;
    private Edad edad;
    private EPS eps;

    public Cliente(ClienteId clienteId, Identificacion identificacion, Nombre nombre, Edad edad, EPS eps) {
        super(clienteId);
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.eps = eps;
    }

    public void cambiarInformacion(Identificacion identificacion, Nombre nombre, Edad edad, EPS eps) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.eps = eps;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public EPS getEps() {
        return eps;
    }
}
