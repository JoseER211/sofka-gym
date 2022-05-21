package co.com.sofka.entrenamiento.actividad.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Material implements ValueObject<String> {
    private final String value;

    public Material(String value) {
        this.value = value;

        if (this.value.length() > 200) {
            throw new IllegalArgumentException("El material no puede contener más de 200 carácteres");
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
        Material material = (Material) o;
        return Objects.equals(value, material.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
