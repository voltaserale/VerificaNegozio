package it.edu.iisvolta;

public class Acquisto {
	private Prodotto prodotto;
    private int quantità;

    public Acquisto(Prodotto prodotto, int quantità) {
        this.prodotto = prodotto;
        this.quantità = quantità;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }  
}
