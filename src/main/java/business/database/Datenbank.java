package business.database;

import business.EmailAddress;
import business.Kunde;

import java.util.List;

public interface Datenbank {
    public Kunde findKundeByEmail(EmailAddress emailAddress);

    public List<Kunde> findAllKunden();

    public void save(Kunde kunde);
}
