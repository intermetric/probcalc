public class BinoomJaotus {

    public static boolean kontrolli(double p) {
        return (p <= 1 && p >= 0);
    }

    public static String arvuta(double p, int n) {

        double keskväärtus = n * p;
        double dispersioon = (n * p) * (1 - p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Parameetritega p=" + Math.round(p * 100.0) / 100.0 + " ja n=" + n + " binoomjaotusega\ndiskreetse" +
                " juhusliku suuruse keskväärtus on " + Math.round(keskväärtus * 100.0) / 100.0 + ",\ndispersioon " +
                Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve " + Math.round(standardhälve * 100.0) / 100.0 + ".";

    }
}