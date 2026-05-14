package Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Mazzo {
    private List<Carta> mazzo;//CREO LISTA
    public void RiempiMazzo() {this.mazzo = new ArrayList<>();// RIEMPIO IL MAZZO
        String[] colori = {"Red", "Blue", "Yellow", "Green"};//GENERO I COLORI
        for (int i = 0; i < colori.length; i++) {//CICLO PER POPOLARE PER COLORE
            String colore = colori[i];
            for (int numero = 1; numero <=9; numero++) {//INSERISCO 9 CARTE PER CIASCUN COLORE
                Carta c = new Carta(colore, String.valueOf(numero));
                mazzo.add(c);
            }
        }
        Collections.shuffle(mazzo);
    }

    public void stampaMazzo() {
        for (Carta c : mazzo) {
            System.out.println(c);
        }
    }
    public Carta pescaCarta() {
        return mazzo.remove(0);
    }

    public int getSize() {
        return mazzo.size();
    }


}
