package business;

import java.util.Objects;

public class Email {

    String value;

    public Email(String value) {
        this.value = value;
    }

    public boolean equals(Email email) {
        return this.value.equals(email.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return this.value;
    }
}
