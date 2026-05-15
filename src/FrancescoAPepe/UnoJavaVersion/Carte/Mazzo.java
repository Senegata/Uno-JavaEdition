package FrancescoAPepe.UnoJavaVersion.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {

    private List<Carta> mazzo;

    // -------------------------
    // RIEMPI IL MAZZO
    // -------------------------
    public void RiempiMazzo() {
        this.mazzo = new ArrayList<>();

        String[] colori = {"Red", "Blue", "Yellow", "Green"};

        for (String colore : colori) {
            for (int numero = 1; numero <= 9; numero++) {
                Carta c = new Carta(colore, String.valueOf(numero));
                mazzo.add(c);
            }
        }

        Collections.shuffle(mazzo);
    }

    // -------------------------
    // STAMPA MAZZO
    // -------------------------
    public void stampaMazzo() {
        for (Carta c : mazzo) {
            System.out.println(c);
        }
    }

    // -------------------------
    // PESCA CARTA
    // -------------------------
    public Carta pescaCarta() {
        return mazzo.remove(0);
    }

    // -------------------------
    // DIMENSIONE MAZZO
    // -------------------------
    public int getSize() {
        return mazzo.size();
    }

    // -------------------------
    // METODI CHE MANCAVANO
    // -------------------------
    public boolean isEmpty() {
        return mazzo.isEmpty();
    }

    public void addAll(List<Carta> carte) {
        mazzo.addAll(carte);
    }

    public void shuffle() {
        Collections.shuffle(mazzo);
    }
}
