import GameLogic.Start;

public class Main {
    public static void main(String[] args) {
        Start game = new Start();
        game.printWelcome();   // opzionale, se vuoi il logo prima
        game.startGame();      // <-- QUI parte il menu
    }
}
