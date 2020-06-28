package business;

import business.database.KundenDatenbank;

import java.util.List;

public class App {

    // die App erzeugt sich eine eigene Instanz einer Kundendatenbank, dadurch
    // besitzt sie nach Start immer eine frische Datenbank!
    KundenDatenbank kundenDatenbank;

    public App() {
        this.kundenDatenbank = new KundenDatenbank();
    }

    public void storeKunde(Kunde kunde) {
        this.kundenDatenbank.save(kunde);
    }

    public Kunde loadKunde(String emailValue) {
        return this.kundenDatenbank.findKundeByEmail(new Email(emailValue));
    }

    public List<Kunde> loadAllKunden() {
        return this.kundenDatenbank.findAllKunden();
    }
}
