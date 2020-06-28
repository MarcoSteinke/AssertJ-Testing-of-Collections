package business.database;

import business.Email;
import business.Kunde;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KundenDatenbank {

    private HashMap<String, Kunde> database;

    public KundenDatenbank() {
        this.database = new HashMap<String, Kunde>();
    }

    public Kunde findKundeByEmail(Email email) {
        return this.database.get(email.getValue());
    }

    public List<Kunde> findAllKunden() {
        return this.database.entrySet()
                .stream()
                .map((entry) -> entry.getValue())
                .collect(Collectors.toList());
    }

    public void save(Kunde kunde) {

        this.database.put(kunde.getEmail().getValue(), kunde);
    }
}
