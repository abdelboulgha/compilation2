package tp1;

public class TokenManager {
    private String chaineEntree;
    private int positionCourante;

    public TokenManager(String chaine) {
        this.chaineEntree = chaine;
        this.positionCourante = 0;
    }

    public char suivant() {
        if (positionCourante < chaineEntree.length()) {
            return chaineEntree.charAt(positionCourante++);
        }
        return '\0';
    }
}
