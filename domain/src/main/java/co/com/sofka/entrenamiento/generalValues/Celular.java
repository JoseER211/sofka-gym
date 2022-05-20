package co.com.sofka.entrenamiento.generalValues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<Integer> {

    private final Integer value;

    public Celular(Integer value) {
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
        Celular celular = (Celular) o;
        return Objects.equals(value, celular.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
