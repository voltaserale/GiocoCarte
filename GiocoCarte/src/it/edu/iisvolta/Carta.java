package it.edu.iisvolta;

public class Carta {
	private int valore;
	private String seme;
	private boolean estratta;
	
	//costruttore
	public Carta(int valore, String seme) {
		super();
		this.valore = valore;
		this.seme = seme;
		estratta=false;		
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	
	//getter
	public boolean isEstratta() {
		return estratta;
	}

	//setter
	public void setEstratta(boolean estratta) {
		this.estratta = estratta;
	}
	
	
	public String getSimbolo() {
		String simbolo;
		if (seme.equals("Bastoni") || seme.equals("Coppe") || 
			seme.equals("Denari") || seme.equals("Spade")) {
			//carta napoletana
			switch(valore) {
			case 8:
				simbolo="fante";
				break;
			case 9:
				simbolo="cavallo";
				break;
			case 10:
				simbolo="re";
				break;
			default:
				simbolo=Integer.toString(valore);	
				break;
			}
		}
		else {
			//carta francese
			switch(valore) {
			case 11:
				simbolo="J";
				break;
			case 12:
				simbolo="Q";
				break;
			case 13:
				simbolo="K";
				break;
			default:
				simbolo=Integer.toString(valore);	
				break;
			}
		}	
		return simbolo;
	}
			
	public float getPunteggio() {
		if (valore<=7)
			return valore;
		else
			return 0.5f;
	}
	

}
