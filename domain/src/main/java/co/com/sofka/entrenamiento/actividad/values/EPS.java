package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EPS implements ValueObject<String> {
    private final String value;

    public EPS(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La EPS no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EPS eps = (EPS) o;
        return Objects.equals(value, eps.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
