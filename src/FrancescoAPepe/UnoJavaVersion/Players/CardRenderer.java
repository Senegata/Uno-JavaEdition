package FrancescoAPepe.UnoJavaVersion.Players;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;

public class CardRenderer {

    private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";

    public String[] renderCard(Carta carta) {

        String number = carta.getNumero().toString();
        String initial = carta.getColore().toString().substring(0, 1);

        // Colore del bordo
        String borderColor = switch (initial) {
            case "R" -> RED;
            case "G" -> GREEN;
            case "Y" -> YELLOW;
            case "B" -> BLUE;
            default -> RESET;
        };

        // Iniziale colorata
        String coloredInitial = borderColor + initial + RESET;

        // Centra ignorando ANSI
        String centered = center(number, 5);

        return new String[]{
                borderColor + "┌───────┐" + RESET,
                borderColor + "│" + RESET + " " + padRight(number, 5) + " " + borderColor + "│" + RESET,
                borderColor + "│" + RESET + " " + centered + " " + borderColor + "│" + RESET,
                borderColor + "│" + RESET + " " + padLeft(number, 5) + " " + borderColor + "│" + RESET,
                borderColor + "└───────┘" + RESET
        };
    }

    private String padRight(String text, int width) {
        return text + " ".repeat(width - text.length());
    }

    private String padLeft(String text, int width) {
        return " ".repeat(width - text.length()) + text;
    }

    private String center(String text, int width) {

        // Rimuove i codici ANSI per calcolare la lunghezza reale
        String plain = text
                .replace("\u001B[0m", "")
                .replace("\u001B[31m", "")
                .replace("\u001B[32m", "")
                .replace("\u001B[33m", "")
                .replace("\u001B[34m", "");

        int len = plain.length();
        int padding = (width - len) / 2;
        int extra = (width - len) % 2;

        return " ".repeat(padding) + text + " ".repeat(padding + extra);
    }
}
