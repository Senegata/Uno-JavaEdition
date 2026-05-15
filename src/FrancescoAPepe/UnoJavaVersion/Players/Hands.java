package FrancescoAPepe.UnoJavaVersion.Players;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;
import FrancescoAPepe.UnoJavaVersion.Carte.Mazzo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Hands {

    private List<Carta> manoGiocatore1;
    private List<Carta> manoGiocatore2;
    private List<Carta> table;
    private CardRenderer renderer = new CardRenderer();

    public Hands() {
        this.manoGiocatore1 = new ArrayList<>();
        this.manoGiocatore2 = new ArrayList<>();
        this.table = new ArrayList<>();
    }

    public void distribuisciCarte(Mazzo mazzo) {
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

    public void stampaManoGiocatore1Orizzontale() {

        System.out.print("      PLAYER 1 HAND");
        System.out.println("        ||        PLAYER 2 HAS: " + manoGiocatore2.size() + " CARDS");
        System.out.println("");

        // 1) Stampa gli indici sopra le carte
        for (int i = 0; i < manoGiocatore1.size(); i++) {
            System.out.print("   (" + (i + 1) + ")      ");
        }
        System.out.println();

        // 2) Ottieni le carte renderizzate
        String[][] rendered = new String[manoGiocatore1.size()][];

        for (int i = 0; i < manoGiocatore1.size(); i++) {
            rendered[i] = renderer.renderCard(manoGiocatore1.get(i));
        }

        // 3) Stampa riga per riga
        for (int r = 0; r < 5; r++) { // ogni carta ha 5 righe
            for (int c = 0; c < manoGiocatore1.size(); c++) {
                System.out.print(rendered[c][r] + "   ");
            }
            System.out.println();
        }
    }


    public void stampaManoGiocatore2Orizzontale() {

        System.out.print("      PLAYER 2 HAND");
        System.out.println("        ||        PLAYER 1 HAS: " + manoGiocatore1.size() + " CARDS");
        System.out.println("");
        // 1) Stampa gli indici sopra le carte
        for (int i = 0; i < manoGiocatore2.size(); i++) {
            System.out.print("   (" + (i + 1) + ")      ");
        }
        System.out.println();

        // 2) Ottieni le carte renderizzate
        String[][] rendered = new String[manoGiocatore2.size()][];

        for (int i = 0; i < manoGiocatore2.size(); i++) {
            rendered[i] = renderer.renderCard(manoGiocatore2.get(i));
        }

        // 3) Stampa riga per riga
        for (int r = 0; r < 5; r++) { // ogni carta ha 5 righe
            for (int c = 0; c < manoGiocatore2.size(); c++) {
                System.out.print(rendered[c][r] + "   ");
            }
            System.out.println();
        }
    }


    public void stampaTable() {
        System.out.println("FrancescoAPepe.UnoJavaVersion.Table:");
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



    // Implementazione del metodo per ordinare per colore (Generico e riutilizzabile)
    private void ordinaManoPerColore(List<Carta> mano) {
        Map<String, Integer> ordineColori = Map.of(
                "Red", 1,
                "Yellow", 2,
                "Green", 3,
                "Blue", 4
        );


        mano.sort(Comparator.comparing(
                c -> ordineColori.getOrDefault(c.getColore(), 99) //    Se il colore non è riconosciuto, lo mettiamo alla fine
        ));
    }

    //  Metodi specifici per ogni giocatore che chiamano il metodo generico
    public void ordinaManoGiocatore1PerColore() {
        ordinaManoPerColore(manoGiocatore1);
    }

    public void ordinaManoGiocatore2PerColore() {
        ordinaManoPerColore(manoGiocatore2);
    }



}




//----------------------
// GUI CARTA
//-----------------------


