package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		//System.out.println("Inserisci il tipo di mazzo: ");
		//String tipo=s.nextLine();
		Mazzo m=new Mazzo("napoletane");
		int sommaUtente=500;	//soldi dell'utente
		float punteggioUtente=0, punteggioBanco=0;
		boolean turnoUtente=true, primaVoltaBanco=true;
		String risposta="s";
		
		Carta c;
		do {
			c=m.estraiCarta();
			Console.clear();
			System.out.print("Turno: ");
			if (turnoUtente) {
				System.out.println("utente");
				if (punteggioUtente==0)		//se è la prima carta
				{
					turnoUtente=false;		//il turno passa al banco
					
				}
				punteggioUtente+=c.getPunteggio();
				
			}				
			else {
				System.out.println("banco");
				if (punteggioBanco==0)		//se è la prima carta del banco torno sull'utente
				{
					turnoUtente=true;
								
				}
					
				punteggioBanco+=c.getPunteggio();
				
			}
			if (c!=null)
				System.out.println("Carta estratta: "+c.getSimbolo()+
						" di "+c.getSeme());
			System.out.println("Punteggio utente: "+punteggioUtente);	
			System.out.println("Punteggio banco: "+punteggioBanco);	
			
			if (turnoUtente && punteggioUtente<=7.5 && !primaVoltaBanco) {
				System.out.println("Vuoi un'altra carta(s/n) ?");
				risposta=s.nextLine();
				if (!risposta.equals("s"))
					turnoUtente=false;	//tocca al banco
				
			} else
			{			
				//if (turnoUtente)
					primaVoltaBanco=false;		
				System.out.println("Premi Enter per continuare");
				s.nextLine();				
			}
			
		} while(
			(turnoUtente && risposta.equals("s") && punteggioUtente<=7.5) ||  //tocca all'utente e l'utente ha detto sì
			(!turnoUtente && punteggioBanco<5));	  //tocca al banco e il punteggio del banco è <5	
		if (punteggioUtente>7.5)
			System.out.println("Vince il banco!");
		else 
			if (punteggioBanco>7.5 || punteggioUtente>punteggioBanco)
				System.out.println("Vince l'utente!");
			else 
				System.out.println("Vince il banco!");
			
		System.out.println("Partita finita!");
		s.nextLine();
		s.close();

	}

	
	
}
