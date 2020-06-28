package business.database;

import business.EmailAddress;
import business.Kunde;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestKundenDatenbank implements Datenbank {

    public HashMap<String, Kunde> database;

    public TestKundenDatenbank() {
        this.database = new HashMap<String, Kunde>();
    }

    @Override
    public Kunde findKundeByEmail(EmailAddress emailAddress) {
        return this.database.get(emailAddress.getValue());
    }

    @Override
    public List<Kunde> findAllKunden() {

        return this.database.entrySet()
                .stream()
                .map((entry) -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void save(Kunde kunde) {

        if (kunde != null)
            this.database.put(kunde.getEmailAddress().getValue(), kunde);
    }
}
