package business.marketing;

import business.Kunde;
import business.database.KundenDatenbank;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class MarketingMailSender {


    private final String preparedText =
            "Na, alles gut bei dir %s ? \n Wir haben diesen Monat eine neue tolle Aktion für dich!";

    LocalTime lastMarketingTime;
    KundenDatenbank kundenDatenbank;

    public MarketingMailSender(KundenDatenbank kundenDatenbank) {
        this.kundenDatenbank = kundenDatenbank;
    }

    public List<String> sendMarketingMails() {
        if (this.lastMarketingTime == null)
            this.lastMarketingTime = LocalTime.now();

        if (MINUTES.between(lastMarketingTime, LocalTime.now()) > 60 * 24 * 30) {
            List<Kunde> kunden = this.kundenDatenbank.findAllKunden();
            List<String> emailNachrichten = new ArrayList<>();

            if (kunden.size() > 0) {

                for (Kunde kunde : kunden) {
                    emailNachrichten.add(this.sendMailToKunde(kunde));
                }
            }
            this.lastMarketingTime = LocalTime.now();
            return emailNachrichten;
        }

        System.out.println("Fehler: Es wurde erst kürzlich eine Mail verschickt.");
        return List.of();
    }

    public String sendMailToKunde(Kunde kunde) {
        return String.format(preparedText, kunde.getFullName());
    }


}
