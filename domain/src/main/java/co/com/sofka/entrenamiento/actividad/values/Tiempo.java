package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalTime;
import java.util.Objects;

public class Tiempo implements ValueObject<LocalTime> {
    private final LocalTime value;

    public Tiempo(LocalTime value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public LocalTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiempo tiempo = (Tiempo) o;
        return Objects.equals(value, tiempo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
