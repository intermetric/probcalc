public class PoissoniJaotus {

    //Küsime kasutajalt vajalikud andmed ja väljastame soovitud tulemuse:
    public static String arvuta(double lambda) {

        double keskväärtus;
        double dispersioon;
        keskväärtus = dispersioon = lambda;
        double standardhälve = Math.sqrt(dispersioon);

        return "Poissoni jaotuse kohaselt on keskväärtus " + keskväärtus
                + ",\ndispersioon " + dispersioon + " ja standardhälve "
                + Math.round(standardhälve * 100.0) / 100.0 + ".";
    }
}