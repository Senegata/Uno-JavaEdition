package FrancescoAPepe.UnoJavaVersion.Carte;
                    // CREAZIONE PROP CARTE
public class Carta {
    private String colore;
    private String numero;

    public Carta(String colore, String numero) {
        this.setColore(colore);
        this.setNumero(numero);
    }
    public void setColore(String colore){
        this.colore = colore;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public String getColore(){return colore;}
    public String getNumero(){return numero;}
                        @Override
                        public String toString() {
                            return colore + " " + numero;
                        }



                    }
