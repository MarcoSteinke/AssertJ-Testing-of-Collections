package business.marketing;

import business.Kunde;
import business.database.KundenDatenbank;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class MarketingMailSender {


    private final String preparedText =
            "Na, alles gut bei dir %s ? \n Du warst seit 30 Tagen nicht mehr aktiv, " +
            "aus diesem Grund möchten wir dich zurück holen !";
    LocalTime lastMarketingTime;
    KundenDatenbank kundenDatenbank;

    public MarketingMailSender(KundenDatenbank kundenDatenbank) {
        this.kundenDatenbank = kundenDatenbank;
    }

    public List<String> sendMarketingMails() {
        if(MINUTES.between(lastMarketingTime, LocalTime.now()) > 60*24*30) {
            List<Kunde> kunden = this.kundenDatenbank.findAllKunden();
            List<String> emailNachrichten = new ArrayList<>();

            if(kunden.size() > 0) {

                for(Kunde kunde : kunden) {
                    emailNachrichten.add(this.sendMailToKunde(kunde));
                }
            }

            return emailNachrichten;
        }

        return List.of();
    }

    public String sendMailToKunde(Kunde kunde) {
        return String.format(preparedText, kunde.getFullName());
    }


}
