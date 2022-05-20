package co.com.sofka.entrenamiento.generalValues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject<String> {

    private final String value;

    public Correo(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El correo no puede estar vacío");
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
        Correo correo = (Correo) o;
        return Objects.equals(value, correo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
