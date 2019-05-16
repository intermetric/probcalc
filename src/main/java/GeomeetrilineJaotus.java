public class GeomeetrilineJaotus {

    public static boolean kontrolli(double p) {
        return (p <= 1 && p >= 0);
    }

    public static String arvuta(double p) {

        double keskväärtus = 1 / p;
        double dispersioon = (1 - p) / (p * p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Parameetriga p=" + Math.round(p * 100.0) / 100.0 + " geomeetrilise jaotusega diskreetse juhusliku suuruse\n" +
                "keskväärtus on " + Math.round(keskväärtus * 100.0) / 100.0 + ", dispersioon " +
                Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve " + Math.round(standardhälve * 100.0) / 100.0 + ".";
    }
}