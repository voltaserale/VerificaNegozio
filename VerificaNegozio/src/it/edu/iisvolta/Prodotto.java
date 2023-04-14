package it.edu.iisvolta;

public class Prodotto {
	private int codice;
    private String descrizione;
    private float prezzo;
    private int giacenza;
    private float sconto;

    public Prodotto(int codice, String descrizione, float prezzo, int giacenza) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.giacenza = giacenza;
        sconto=0;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getPrezzo() {
        return prezzo*(1-sconto);
    }

    public int getGiacenza() {
        return giacenza;
    }

    public float getSconto() {
        return sconto;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(float prezzo) {
        if (prezzo>0)
            this.prezzo = prezzo;
        else
            System.out.println("Prezzo non valido!");
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    public void setSconto(float sconto) {
        this.sconto = sconto;
    }
    
    public void rifornisci(int qta) {
        giacenza+=qta;
    }
    
    public void applicaSconto(float perc) {
        sconto=perc;        
    }
    
    public void rimuoviSconto() {
        sconto=0;
    }
}
