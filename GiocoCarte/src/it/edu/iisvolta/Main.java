package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		System.out.println("Inserisci il tipo di mazzo: ");
		String tipo=s.nextLine();
		Mazzo m=new Mazzo(tipo);
		
		
		Carta c;
		do {
			c=m.estraiCarta();
			if (c!=null)
				System.out.println("Carta estratta: "+c.getSimbolo()+
						" di "+c.getSeme());
		} while(c!=null);
		
		System.out.println("Tutte le carte sono state estratte!");
		s.close();

	}

}
