package business;

import business.database.KundenDatenbank;
import business.marketing.MarketingMailSender;

import java.util.List;

public class App {

    // die App erzeugt sich eine eigene Instanz einer Kundendatenbank, dadurch
    // besitzt sie nach Start immer eine frische Datenbank!
    KundenDatenbank kundenDatenbank;
    MarketingMailSender marketingMailSender;

    public App() {
        this.kundenDatenbank = new KundenDatenbank();
        this.marketingMailSender = new MarketingMailSender(this.kundenDatenbank);
    }

    public void storeKunde(Kunde kunde) {
        this.kundenDatenbank.save(kunde);
    }

    public void sendMarketingMails() {
        this.marketingMailSender.sendMarketingMails();
    }

    public Kunde loadKunde(String emailValue) {
        return this.kundenDatenbank.findKundeByEmail(new EmailAddress(emailValue));
    }

    public List<Kunde> loadAllKunden() {
        return this.kundenDatenbank.findAllKunden();
    }
}
