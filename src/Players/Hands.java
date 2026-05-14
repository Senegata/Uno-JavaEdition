package Players;

import Carte.Carta;
import Carte.Mazzo;

import java.util.ArrayList;
import java.util.List;

public class Hands {

    private List<Carta> manoGiocatore1;
    private List<Carta> manoGiocatore2;
    private List<Carta> table;

    public Hands() {
        this.manoGiocatore1 = new ArrayList<>();
        this.manoGiocatore2 = new ArrayList<>();
        this.table = new ArrayList<>();
    }

    public void distribuisciCarte(Mazzo mazzo){
        for (int i = 0; i < 6; i++) {
            // Giocatore 1 riceve Carta
            Carta c1 = mazzo.pescaCarta();
            manoGiocatore1.add(c1);

            // Giocatore 2 riceve Carta
            Carta c2 = mazzo.pescaCarta();
            manoGiocatore2.add(c2);
        }

        // Prima carta sul tavolo
        Carta c3 = mazzo.pescaCarta();
        table.add(c3);
    }

    // -------------------------
    // STAMPE
    // -------------------------

    public void stampaManoGiocatore1Numerata() {
        System.out.println("Player 1 Hand:");
        for (int i = 0; i < manoGiocatore1.size(); i++) {
            System.out.println((i + 1) + ") " + manoGiocatore1.get(i));
        }
    }

    public void stampaManoGiocatore2Numerata() {
        System.out.println("Player 2 Hand:");
        for (int i = 0; i < manoGiocatore2.size(); i++) {
            System.out.println((i + 1) + ") " + manoGiocatore2.get(i));
        }
    }

    public void stampaTable() {
        System.out.println("Table:");
        for (Carta c : table) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // -------------------------
    // GETTERS
    // -------------------------

    public List<Carta> getManoGiocatore1() {
        return manoGiocatore1;
    }

    public List<Carta> getManoGiocatore2() {
        return manoGiocatore2;
    }

    public Carta getCartaSulTavolo() {
        return table.get(table.size() - 1); // ultima carta giocata
    }

    // -------------------------
    // GIOCARE UNA CARTA
    // -------------------------

    public Carta giocaCartaGiocatore1(int index) {
        return manoGiocatore1.remove(index);
    }

    public Carta giocaCartaGiocatore2(int index) {
        return manoGiocatore2.remove(index);
    }

    public void aggiungiAlTavolo(Carta carta) {
        table.add(carta);
    }
}
