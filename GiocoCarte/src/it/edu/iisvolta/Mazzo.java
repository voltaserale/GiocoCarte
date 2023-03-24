package it.edu.iisvolta;

import java.util.ArrayList;

public class Mazzo {
	private String tipologia;
	private ArrayList<Carta> elencoCarte=new ArrayList<>();
	
	public Mazzo(String tipologia) {
		super();
		this.tipologia = tipologia;
		switch(tipologia) {
			case "napoletane":
				for (int seme=1;seme<=4;seme++)
					for(int valore=1;valore<=10;valore++) {	
						Carta c;
						switch(seme) {
							case 1:
								c=new Carta(valore,"Bastoni");
								break;
							case 2:
								c=new Carta(valore,"Denari");
								break;
							case 3:
								c=new Carta(valore,"Coppe");
								break;
							case 4:
								c=new Carta(valore,"Spade");
								break;
							default:
								c=null;
								break;
						}
						elencoCarte.add(c);						
					}
				break;
			case "francesi":
				for (int seme=1;seme<=4;seme++)
					for(int valore=1;valore<=13;valore++) {	
						Carta c;
						switch(seme) {
							case 1:
								c=new Carta(valore,"Fiori");
								break;
							case 2:
								c=new Carta(valore,"Picche");
								break;
							case 3:
								c=new Carta(valore,"Quadri");
								break;
							case 4:
								c=new Carta(valore,"Cuori");
								break;
							default:
								c=null;
								break;
						}
						elencoCarte.add(c);						
					}
				break;
			
		}
	}
	
	
}
