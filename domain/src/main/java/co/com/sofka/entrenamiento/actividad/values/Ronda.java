package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ronda implements ValueObject<Integer> {
    private final Integer value;

    public Ronda(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ronda ronda = (Ronda) o;
        return Objects.equals(value, ronda.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
