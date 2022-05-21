package co.com.sofka.entrenamiento.programa.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valoracion implements ValueObject<Double> {
    private final Double value;

    public Valoracion(Double value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 1) {
            throw new IllegalArgumentException("La valoración no puede ser menor a 1");
        }

        if (this.value > 5) {
            throw new IllegalArgumentException("La valoración no puede ser mayor a 5");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valoracion that = (Valoracion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
