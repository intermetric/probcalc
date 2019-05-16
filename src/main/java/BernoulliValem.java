public class BernoulliValem {

    public static boolean kontrolli(double p, int n, int k) {
        return (p <= 1 && p >= 0 && n >= k);
    }

    public static String arvuta(double p, int n, int k) {

        double tõenäosus = Hüpergeomeetriline.kombinatsioonid(k, n) * Math.pow(p, k) * Math.pow((1 - p), (n - k));
        return "Igal katsel tõenäosusega p=" + Math.round(p * 100.0) / 100.0 + " toimuva\nsündmuse puhul on tõenäosus, et " +
                n + "-st\nkatsest toimub sündmus " + k + " katsel: " + Math.round(tõenäosus * 1000.0) / 1000.0 + ".";
    }

}