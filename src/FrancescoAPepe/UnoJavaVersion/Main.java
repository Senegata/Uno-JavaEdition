package FrancescoAPepe.UnoJavaVersion;

import FrancescoAPepe.UnoJavaVersion.GameLogic.Start;

public class Main {
    public static void main(String[] args) {
        Start game = new Start();
        game.printWelcome();
        game.startGame();
    }
}
