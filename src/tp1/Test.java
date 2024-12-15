
package tp1;

public class Test {
    public static void main(String[] args) {
        String[] tests = {"cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbbcr", "cdcbbb", ""};

        for (String test : tests) {
            TokenManager tm = new TokenManager(test);
            Parseur p1 = new Parseur(tm);

            try {
                p1.parse();
                System.out.println("Input: '" + test + "' => est valide");
            } catch (RuntimeException e) {
                System.out.println("Input: '" + test + "' => n'est pas valide");
            }
        }
    }
}
