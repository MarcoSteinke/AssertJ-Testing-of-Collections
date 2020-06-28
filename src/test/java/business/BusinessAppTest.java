package business;

import business.database.TestKundenDatenbank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BusinessAppTest {

    @Test
    void kundeSpeichern() {
        // AAA

        // arrange
        TestKundenDatenbank datenbank = new TestKundenDatenbank();
        String emailAddress = "peter@gmail.com";
        Kunde kunde = Kunde.create("Peter", emailAddress);

        // act
        datenbank.save(kunde);
        Kunde resultKunde = datenbank.database.get(emailAddress);

        // assert
        assertThat(kunde).isEqualTo(resultKunde);

    }

    @Test
    void kundeLaden() {
        // AAA

        // arrange
        TestKundenDatenbank datenbank = new TestKundenDatenbank();
        EmailAddress emailAddress = new EmailAddress("peter@gmail.com");
        Kunde kunde = Kunde.create("Peter", emailAddress.getValue());

        // act
        datenbank.save(kunde);
        Kunde resultKunde = datenbank.findKundeByEmail(emailAddress);

        assertThat(kunde).isEqualTo(resultKunde).isNotNull();

    }

    @Test
    void keinKundeWirdGespeichert() {
        // AAA

        // arrange
        TestKundenDatenbank datenbank = new TestKundenDatenbank();

        // act
        datenbank.save(null);

        // assert
        assertThat(datenbank.database.size()).isEqualTo(0);
    }

    @Test
    void keinKundeWirdAusLeererDatenbankGeladen() {
        TestKundenDatenbank datenbank = new TestKundenDatenbank();

        // act
        Kunde kunde = datenbank.findKundeByEmail(new EmailAddress(""));

        // assert
        assertThat(kunde).isNull();
    }

    @Test
    void mehrereKundenWerdenGespeichertUndGeladen() {
        // AAA

        // arrange
        TestKundenDatenbank datenbank = new TestKundenDatenbank();

        List<EmailAddress> addresses = List.of(
                new EmailAddress("peter1@gmail.com"),
                new EmailAddress("peter2@gmail.com"),
                new EmailAddress("peter3@gmail.com")
        );
        List<Kunde> kunden = new ArrayList<>();


        addresses.forEach((address) -> {
            kunden.add(Kunde.create(
                    "Peter" + (int) (Math.random() * 10),
                    address.getValue()));
        });

        kunden.forEach((kunde) -> datenbank.save(kunde));


        // act

        List<Kunde> resultKunden = datenbank.findAllKunden();

        // assert
        assertThat(resultKunden).containsAll(kunden);

    }

    @Test
    void keineKundenBeiFindall() {
        // act
        TestKundenDatenbank testKundenDatenbank = new TestKundenDatenbank();
        testKundenDatenbank.save(null);

        // act
        List<Kunde> resultKunden = testKundenDatenbank.findAllKunden();

        // assert
        assertThat(resultKunden.size()).isEqualTo(0);
    }
}
