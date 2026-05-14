package FrancescoAPepe.UnoJavaVersion.GameLogic;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;
import FrancescoAPepe.UnoJavaVersion.Carte.Mazzo;
import FrancescoAPepe.UnoJavaVersion.Players.CardRenderer;
import FrancescoAPepe.UnoJavaVersion.Players.Hands;
import FrancescoAPepe.UnoJavaVersion.Table.Table;

import java.util.Scanner;

public class Actions {

    private Hands hands;
    private Table table;
    private Mazzo mazzo;
    private Scanner scanner = new Scanner(System.in);
    private CardRenderer renderer = new CardRenderer();


    public Actions(Hands hands, Table table, Mazzo mazzo) {
        this.hands = hands;
        this.table = table;
        this.mazzo = mazzo;
    }

    public void startGameLoopSinglePlayer() {

        while (true) {

            turnoGiocatore1();

            if (hands.getManoGiocatore1().isEmpty()) {
                printWinner(1);
                break;
            }

            turnoAI(); // <-- IA al posto del giocatore 2

            if (hands.getManoGiocatore2().isEmpty()) {
                printWinner(2);
                break;
            }

            System.out.println("\n--- NEW TURN ---\n");
        }
    }


    public void startGameLoopMultiplayer() {

        while (true) {

            turnoGiocatore1();

            // VITTORIA GIOCATORE 1
            if (hands.getManoGiocatore1().isEmpty()) {
                printWinner(1);
                break;
            }

            turnoGiocatore2();

            // VITTORIA GIOCATORE 2
            if (hands.getManoGiocatore2().isEmpty()) {
                printWinner(2);
                break;
            }

            System.out.println("\n--- NEW TURN ---\n");
        }
    }

    // -------------------------
    // TURNO GIOCATORE 1
    // -------------------------
    private void turnoGiocatore1() {

        System.out.println("\n=== TURN PLAYER 1 ===");

        while (true) {

            String[] rendered = renderer.renderCard(table.getCartaSulTavolo());
            for (String r : rendered) System.out.println(r);

            System.out.println("----------------------------");
            hands.stampaManoGiocatore1Orizzontale();

            System.out.print("Choose a card to play(0 to draw): ");

            // --- INPUT SICURO ---
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.println("Invalid choice! Try again!");
                continue;
            }

            int scelta = Integer.parseInt(input) - 1;

            // PESCA
            if (scelta == -1) {
                pescaCartaGiocatore1();
                break;
            }

            // RANGE
            if (scelta < 0 || scelta >= hands.getManoGiocatore1().size()) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            Carta cartaScelta = hands.getManoGiocatore1().get(scelta);

            if (puoGiocare(cartaScelta)) {
                hands.giocaCartaGiocatore1(scelta);
                table.setCartaSulTavolo(cartaScelta);
                System.out.println("Player 1 played: " + cartaScelta);
                break; // esce dal turno
            } else {
                System.out.println("❌ You can't play that card! Try again");
            }
        }
    }

    // -------------------------
    // TURNO GIOCATORE 2
    // -------------------------
    private void turnoGiocatore2() {

        System.out.println("\n=== TURN PLAYER 2 ===");

        while (true) {

            String[] rendered = renderer.renderCard(table.getCartaSulTavolo());
            for (String r : rendered) System.out.println(r);
            System.out.println("----------------------------");
            hands.stampaManoGiocatore2Orizzontale();

            System.out.print("Player 2, choose a card to play (0 to draw): ");

            // --- INPUT SICURO ---
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.println("Invalid choise! Try again");
                continue;
            }

            int scelta = Integer.parseInt(input) - 1;

            // PESCA
            if (scelta == -1) {
                pescaCartaGiocatore2();
                break;
            }

            // RANGE
            if (scelta < 0 || scelta >= hands.getManoGiocatore2().size()) {
                System.out.println("Invalid choise! Try again");
                continue;
            }

            Carta cartaScelta = hands.getManoGiocatore2().get(scelta);

            if (puoGiocare(cartaScelta)) {
                hands.giocaCartaGiocatore2(scelta);
                table.setCartaSulTavolo(cartaScelta);
                System.out.println("Player 2 played " + cartaScelta);
                break;
            } else {
                System.out.println("❌ You can't play this card. Try again");
            }
        }
    }

    private void turnoAI() {

        System.out.println("\n=== AI TURN ===");
        System.out.println("Card on the table: " + table.getCartaSulTavolo());
        System.out.println("----------------------------");
        hands.stampaManoGiocatore2Orizzontale();

        // 1. Cerca una carta valida
        for (int i = 0; i < hands.getManoGiocatore2().size(); i++) {
            Carta carta = hands.getManoGiocatore2().get(i);

            if (puoGiocare(carta)) {
                System.out.println("AI plays: " + carta);
                hands.giocaCartaGiocatore2(i);
                table.setCartaSulTavolo(carta);
                return;
            }
        }

        // 2. Nessuna carta valida → pesca
        System.out.println("AI cannot play. Drawing a card...");
        pescaCartaGiocatore2();
    }


    // -------------------------
    // CONTROLLO VALIDITÀ CARTA
    // -------------------------
    private boolean puoGiocare(Carta carta) {
        Carta tavolo = table.getCartaSulTavolo();

        boolean stessoColore = carta.getColore().equals(tavolo.getColore());
        boolean stessoNumero = carta.getNumero().equals(tavolo.getNumero());

        return stessoColore || stessoNumero;
    }

    // -------------------------
    // PESCA G1
    // -------------------------
    private void pescaCartaGiocatore1() {
        if (mazzo.getSize() == 0) {
            System.out.println("The Deck is empty!");
            return;
        }

        Carta pescata = mazzo.pescaCarta();
        hands.getManoGiocatore1().add(pescata);

        System.out.println("You drew: " + pescata);
    }

    // -------------------------
    // PESCA G2
    // -------------------------
    private void pescaCartaGiocatore2() {
        if (mazzo.getSize() == 0) {
            System.out.println("The deck is empty!");
            return;
        }

        Carta pescata = mazzo.pescaCarta();
        hands.getManoGiocatore2().add(pescata);

        System.out.println("Player 2 drew: " + pescata);
    }

    private void printWinner(int player) {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String red = "\u001B[31m";

        System.out.println();
        System.out.println(green +
                "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ \n" +
                "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗\n" +
                "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝\n" +
                "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗\n" +
                "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║\n" +
                " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝" + reset);

        System.out.println();

        if (player == 1) {
            System.out.println(yellow + "🎉 PLAYER 1 WINS THE GAME! 🎉" + reset);
        } else {
            System.out.println(red + "🔥 PLAYER 2 WINS THE GAME! 🔥" + reset);
        }

        System.out.println();
        System.out.println("Thanks for playing UNO Java Edition!");
        System.out.println();
    }

}

