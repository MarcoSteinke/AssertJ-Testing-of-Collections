package business;

import business.annotation.Id;

public class Kunde {

    @Id
    Email email;
    String fullName;

    private Kunde(String fullName, String email) {
        this.fullName = fullName;
        this.email = new Email(email);
    }

    public static Kunde create(String fullName, String email) {
        return new Kunde(fullName, email);
    }

    public Email getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return fullName + "\t" + email.getValue();
    }
}
