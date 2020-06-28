package business;

import business.annotation.Id;

public class Kunde {

    @Id
    EmailAddress emailAddress;

    String fullName;

    private Kunde(String fullName, String email) {
        this.fullName = fullName;
        this.emailAddress = new EmailAddress(email);
    }

    public String getFullName() {
        return fullName;
    }

    public static Kunde create(String fullName, String email) {
        return new Kunde(fullName, email);
    }

    public EmailAddress getEmailAddress() {
        return this.emailAddress;
    }

    public boolean equals(Kunde kunde) {
        return this.fullName.equals(kunde.fullName) && this.emailAddress.equals(kunde.getEmailAddress());
    }

    public String toString() {
        return fullName + "\t" + emailAddress.getValue();
    }
}
