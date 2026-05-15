package FrancescoAPepe.UnoJavaVersion.Table;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private Carta cartaSulTavolo;
    private List<Carta> scarti = new ArrayList<>();

    public void setCartaSulTavolo(Carta carta) {
        this.cartaSulTavolo = carta;
    }

    public Carta getCartaSulTavolo() {
        return cartaSulTavolo;
    }

    public boolean puoEssereGiocata(Carta carta) {
        boolean stessoColore = carta.getColore().equals(cartaSulTavolo.getColore());
        boolean stessoNumero = carta.getNumero().equals(cartaSulTavolo.getNumero());
        return stessoColore || stessoNumero;
    }

    public boolean giocaCarta(Carta carta) {
        if (puoEssereGiocata(carta)) {
            this.cartaSulTavolo = carta;
            return true;
        }
        return false;
    }
    public void aggiungiScarto(Carta carta) {
        scarti.add(carta);
    }

    public List<Carta> getScarti() {
        return scarti;
    }
}
