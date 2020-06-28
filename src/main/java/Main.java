import business.App;
import business.Kunde;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        App app = new App();

        Kunde kunde1 = Kunde.create("Max Mustermann", "maxmustermann@hhu.de");
        Kunde kunde2 = Kunde.create("Maria Musterfrau", "mmusterfrau@hhu.de");

        app.storeKunde(kunde1);
        app.storeKunde(kunde2);

        Kunde geladenerKunde1 = app.loadKunde("maxmustermann@hhu.de");

        System.out.println("\nGebe den Kunden mit der Emailadresse \"maxmustermann@hhu.de\" aus:");
        System.out.println(geladenerKunde1);
        System.out.println("\n".repeat(3));


        System.out.println("Gebe alle Kunden aus:");
        List<Kunde> kunden = app.loadAllKunden();
        for (Kunde kunde : kunden) {
            System.out.println(kunde);
        }

        app.printMarketingMails();
    }
}
