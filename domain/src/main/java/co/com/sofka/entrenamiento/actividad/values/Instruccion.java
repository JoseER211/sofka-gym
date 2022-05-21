package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Instruccion implements ValueObject<String> {
    private final String value;

    public Instruccion(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La instrucción no puede estar vacía");
        }
        if (this.value.length() > 400) {
            throw new IllegalArgumentException("La instrucción no puede contener más de 400 carácteres");
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
        Instruccion that = (Instruccion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
