package dayTwo;

public class Datensatz {

	private String feld1;
	private char feld2;
	private String feld3;
	private String[] zahl;
	private String[] feld2extr;
	private int count;
	private int low;
	private int high;
	
	public Datensatz(){
		
	}
	
	public void setFeld1(String feld1){
		zahl = feld1.split("-");
		this.low = Integer.parseInt(zahl[0]);
		this.high = Integer.parseInt(zahl[1]);
		this.feld1 = feld1;
		
	}
	
	public void setFeld2(String feld2){
		String buf;
		feld2extr = feld2.split(":"); //loesche Doppelpunkt aus dem Feld
		buf = feld2extr[0];
		this.feld2 = buf.charAt(0);
		
	}
	

	public void setFeld3(String feld3){
		this.feld3 = feld3;
	}
	
	public void setLetterCount(int count){
		this.count = count;
	}
	
	public int getLetterCount(){
				
		return count;
	}
	
	public int getLow(){
		zahl = feld1.split("-");
		return low;
	}
	
	public int getHigh(){
		
		return high;
	}
	
	public String getFeld3Adv(){ //return string + zusaetzlichen leer char, weil index bei 1 beginnt
		
		return " "+ feld3;
	}
	
	public Character getFeld2(){
		return feld2;
	}
	
	public String getFeld3(){
		return feld3;
	}
}
