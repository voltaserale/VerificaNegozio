package it.edu.iisvolta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		ArrayList<Prodotto> elencoProdotti=new ArrayList<>();
        ArrayList<Scontrino> elencoScontrini=new ArrayList<>();
        Scanner s=new Scanner(System.in);
        String scelta;
        String risp;
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        do {
            Console.clear();
            System.out.println("GESTIONE NEGOZIO\n");
            System.out.println("1 - Visualizza prodotti");
            System.out.println("2 - Aggiungi prodotto");            
            System.out.println("3 - Rifornisci");
            System.out.println("4 - Visualizza scontrino");
            System.out.println("5 - Emetti scontrino");
            System.out.println("6 - Applica sconto");
            System.out.println("7 - Rimuovi sconto");
            System.out.println("9 - Esci\n");
            System.out.print("Inserisci la tua scelta: ");
            scelta=s.nextLine();
            
            switch(scelta) {
                case "1":  // visualizza l'elenco dei prodotti
                    System.out.println("Elenco prodotti:");
                    for(Prodotto p:elencoProdotti) {                    
                        System.out.println("Codice: "+p.getCodice());
                        System.out.println("Descrizione: "+p.getDescrizione());
                        System.out.println("Giacenza: "+p.getGiacenza());
                        System.out.println("Prezzo: "+p.getPrezzo());
                        System.out.println();
                    }
                    break;
                case "2":       //aggiungi prodotto
                    int codice;                    
                    boolean trovato;
                    System.out.print("Inserisci il codice: ");
                    codice=Integer.parseInt(s.nextLine());
                    
                    trovato=false;
                    //verifico che il codice non sia già presente
                    for(Prodotto p:elencoProdotti) {
                        if (codice==p.getCodice())
                            trovato=true;       //il codice esiste
                    } 
                    if (!trovato)       //posso aggiungere il prodotto
                    {                        
                        System.out.print("Inserisci la descrizione: ");
                        String descrizione=s.nextLine();
                        System.out.print("Inserisci il prezzo: ");
                        float prezzo=Float.parseFloat(s.nextLine());
                        System.out.print("Inserisci la giacenza: ");
                        int giacenza=Integer.parseInt(s.nextLine());
                        elencoProdotti.add(new Prodotto(codice,descrizione,prezzo,giacenza));
                    }
                    else //il codice già esiste
                        System.out.println("Il codice è già esistente!");
                    break;
                 case "3":      //Rifornisci                   
                    System.out.print("Inserisci il codice: ");
                    codice=Integer.parseInt(s.nextLine());
                    
                    trovato=false;
                    //verifico che il codice non sia già presente
                    for(Prodotto p:elencoProdotti) {
                        if (codice==p.getCodice()) {
                            trovato=true;       //il codice esiste
                            System.out.print("Inserisci la quantità: ");
                            int qta=Integer.parseInt(s.nextLine());
                            p.rifornisci(qta);
                        }                            
                    } 
                    if (!trovato)
                         System.out.println("Il prodotto non esiste!");
                    break;
                    
                case "4":      //Visualizza scontrino
                    System.out.print("Inserisci numero dello scontrino: ");
                    int nrScontrino=Integer.parseInt(s.nextLine());
                    
                    trovato=false;
                    
                    for(Scontrino sc:elencoScontrini) {
                        if (nrScontrino==sc.getNr()) {
                            System.out.println("Data : "+dateFormat.format(sc.getData()));
                            trovato=true;       //il codice esiste
                            for (Acquisto a:sc.getElencoAcquisti())
                               System.out.println(
                                    a.getProdotto().getDescrizione()+" x "+
                                    a.getQuantità()+" : "+
                                    a.getQuantità()*a.getProdotto().getPrezzo());
                        }                            
                    } 
                    if (!trovato)
                         System.out.println("Lo scontrino non esiste!");
                    break;
                case "5":      //Emetti scontrino
                    System.out.print("Inserisci numero dello scontrino: ");
                    nrScontrino=Integer.parseInt(s.nextLine());
                    System.out.print("Inserisci data dello scontrino: ");
                    
				Date dataScontrino;
				try {
					dataScontrino = dateFormat.parse(s.nextLine());
					Scontrino sc=new Scontrino(nrScontrino,dataScontrino);
                    
                    do {
                         System.out.print("Inserisci il codice: ");
                         codice=Integer.parseInt(s.nextLine());
                         trovato=false;
                         //verifico che il codice non sia già presente
                         for(Prodotto p:elencoProdotti) {
                             if (codice==p.getCodice()) {
                                trovato=true;       //il codice esiste
                                System.out.print("Inserisci la quantità: ");
                                int qta=Integer.parseInt(s.nextLine());
                                sc.aggiungiAcquisto(new Acquisto(p,qta));
                             }                            
                         } 
                         if (!trovato)
                             System.out.println("Il prodotto non esiste!");
                         System.out.println("Vuoi inserire un altro prodotto? ");
                         risp=s.nextLine();
                        
                    } while(risp.equals("sì"));
                    elencoScontrini.add(sc);
				
				} catch (ParseException e) {
					System.out.println("Data non valida!");
				}
                    
            }
            
            System.out.println("Premi Enter per continuare...");
            s.nextLine();
        } while(!scelta.equals("9"));
        s.close();

	}

}
