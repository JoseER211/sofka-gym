package co.com.sofka.entrenamiento.actividad.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.entrenamiento.actividad.values.ClienteId;
import co.com.sofka.entrenamiento.actividad.values.EPS;
import co.com.sofka.entrenamiento.actividad.values.Edad;
import co.com.sofka.entrenamiento.actividad.values.Identificacion;
import co.com.sofka.entrenamiento.generalValues.Nombre;

public class ClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final Identificacion identificacion;
    private final Nombre nombre;
    private final Edad edad;
    private final EPS eps;

    public ClienteAgregado(ClienteId clienteId, Identificacion identificacion, Nombre nombre, Edad edad, EPS eps) {
        super("sofka.actividad.clienteagregado");
        this.clienteId = clienteId;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.eps = eps;
    }

    public ClienteId getClienteId() {
        return clienteId;
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
