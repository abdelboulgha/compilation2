package tp1;

public class Parseur {
    private char tokenCourant;
    private TokenManager tm;

    public Parseur(TokenManager tm) {
        this.tm = tm;
        avancer();
    }

    private void avancer() {
        tokenCourant = tm.suivant();
    }

    private void consommer(char attendu) {
        if (tokenCourant == attendu) {
            avancer();
        } else {
            throw new RuntimeException("Erreur : attendu '" + attendu + "' mais '" + tokenCourant + "' a été trouvé.");
        }
    }

    public void parseS() {
        if (tokenCourant == 'b') {
            consommer('b');
            parseS();
            consommer('b');
        } else if (tokenCourant == 'c') {
            consommer('c');
            parseA();
            consommer('c');
        } else {
            throw new RuntimeException("Erreur : caractère inattendu '" + tokenCourant + "'");
        }
    }

    public void parseA() {
        if (tokenCourant == 'b') {
            consommer('b');
            parseA();
            parseA();
        } else if (tokenCourant == 'c') {
            consommer('c');
            parseA();
            parseS();
            parseA();
            consommer('b');
        } else if (tokenCourant == 'd') {
        	 consommer('d');
        	 consommer('c');
        	 consommer('b');
    
        } else {
            throw new RuntimeException("Erreur : caractère inattendu '" + tokenCourant + "'");
        }
    }

    public void parse() {
        parseS();
        if (tokenCourant != '\0') {
            throw new RuntimeException("Erreur : caractère inattendu '" + tokenCourant + "' trouvé à la fin.");
        }
    }
}
