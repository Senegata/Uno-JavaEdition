package FrancescoAPepe.UnoJavaVersion.GameLogic;

import FrancescoAPepe.UnoJavaVersion.Carte.Mazzo;
import FrancescoAPepe.UnoJavaVersion.Players.Hands;
import FrancescoAPepe.UnoJavaVersion.Table.Table;

import java.util.Scanner;

public class Start {
    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select game mode:");
        System.out.println("1) 1 Player (vs AI)");
        System.out.println("2) 2 Players");

        System.out.print("Your choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            startSinglePlayerGame();
        } else if (choice.equals("2")) {
            startTwoPlayerGame();
        } else {
            System.out.println("Invalid choice!");
        }
    }
    private void startSinglePlayerGame() {

        Mazzo m = new Mazzo();
        m.RiempiMazzo();

        Hands h = new Hands();
        h.distribuisciCarte(m);

        Table t = new Table();
        t.setCartaSulTavolo(m.pescaCarta());

        Actions actions = new Actions(h, t, m);
        actions.startGameLoopSinglePlayer();
    }
    private void startTwoPlayerGame() {

        Mazzo m = new Mazzo();
        m.RiempiMazzo();

        Hands h = new Hands();
        h.distribuisciCarte(m);

        Table t = new Table();
        t.setCartaSulTavolo(m.pescaCarta());

        Actions actions = new Actions(h, t, m);
        actions.startGameLoopMultiplayer();
    }

    public void printWelcome() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String green = "\u001B[32m";

        System.out.println();
        System.out.println(red +
                "██╗   ██╗███╗   ██╗ ██████╗ \n" +
                "██║   ██║████╗  ██║██╔═══██╗\n" +
                "██║   ██║██╔██╗ ██║██║   ██║\n" +
                "██║   ██║██║╚██╗██║██║   ██║\n" +
                "╚██████╔╝██║ ╚████║╚██████╔╝\n" +
                " ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ " + reset);

        System.out.println();
        System.out.println(yellow + "Welcome to the UNO Java Edition!" + reset);
        System.out.println(blue + "Match colors, match numbers, and outsmart your opponent." + reset);
        System.out.println(green + "Let the chaos begin!" + reset);
        System.out.println();
    }

}