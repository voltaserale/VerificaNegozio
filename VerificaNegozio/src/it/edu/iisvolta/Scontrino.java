package it.edu.iisvolta;

import java.util.ArrayList;
import java.util.Date;

public class Scontrino {
	 private int nr;
	    private Date data;
	    private ArrayList<Acquisto> elencoAcquisti;

	    public Scontrino(int nr, Date data) {
	        this.nr = nr;
	        this.data = data;
	        elencoAcquisti=new ArrayList<>();
	    }
	    
	    public void aggiungiAcquisto(Acquisto acquisto) {
	        elencoAcquisti.add(acquisto);
	    }
	    
	    public float calcolaTotale() {
	        float ris=0;
	        for(Acquisto a: elencoAcquisti)
	            ris+=a.getProdotto().getPrezzo()*a.getQuantità();
	        return ris;
	    }

	    public int getNr() {
	        return nr;
	    }

	    public Date getData() {
	        return data;
	    }

	    public ArrayList<Acquisto> getElencoAcquisti() {
	        return elencoAcquisti;
	    }
}
