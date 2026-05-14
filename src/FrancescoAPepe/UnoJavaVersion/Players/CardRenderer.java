package FrancescoAPepe.UnoJavaVersion.Players;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;

public class CardRenderer {

    public String[] renderCard(Carta carta) {

        String number = carta.getNumero().toString();
        String initial = carta.getColore().toString().substring(0, 1);

        String centered = center(initial, 2);

        return new String[]{
                "┌───────┐",
                "│ " + padRight(number, 5) + " │",
                "│ " + centered + " │",
                "│ " + padLeft(number, 5) + " │",
                "└───────┘"
        };
    }

    private String padRight(String text, int width) {
        return text + " ".repeat(width - text.length());
    }

    private String padLeft(String text, int width) {
        return " ".repeat(width - text.length()) + text;
    }

    private String center(String text, int width) {
        return " ".repeat(width) + text + " ".repeat(width);
    }
}
