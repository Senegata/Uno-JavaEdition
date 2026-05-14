package FrancescoAPepe.UnoJavaVersion.Table;

import FrancescoAPepe.UnoJavaVersion.Carte.Carta;

public class Table {

    private Carta cartaSulTavolo;

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
}
