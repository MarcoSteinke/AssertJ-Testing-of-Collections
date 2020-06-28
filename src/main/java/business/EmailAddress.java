package business;

import java.util.Objects;

public class EmailAddress {

    String value;

    public EmailAddress(String value) {
        this.value = value;
    }

    public boolean equals(EmailAddress emailAddress) {
        return this.value.equals(emailAddress.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return this.value;
    }
}
