public class BernoulliValem {

    public static boolean kontrolli(double p, int n, int k) {
        return (p <= 1 && p >= 0 && n >= k);
    }

    //Kombinatsioonide valem:
    static long kombinatsioonid(int k, int n) {
        long lugeja = 1L;
        long nimetaja = 1L;
        if (k > n - k) {
            for (int i = k + 1; i < n + 1; i++) {
                lugeja *= i;
            }
            for (int i = 1; i < n - k + 1; i++) {
                nimetaja *= i;
            }
        } else {
            for (int i = n - k + 1; i < n + 1; i++) {
                lugeja *= i;
            }
            for (int i = 1; i < k + 1; i++) {
                nimetaja *= i;
            }
        }
        return lugeja / nimetaja;
    }

    public static String arvuta(double p, int n, int k) {

        double tõenäosus = kombinatsioonid(k, n) * Math.pow(p, k) * Math.pow((1 - p), (n - k));
        return "Igal katsel tõenäosusega p=" + Math.round(p * 100.0) / 100.0 + " toimuva\nsündmuse puhul on tõenäosus, et " +
                n + "-st\nkatsest toimub sündmus " + k + " katsel: " + Math.round(tõenäosus * 1000.0) / 1000.0 + ".";
    }

}