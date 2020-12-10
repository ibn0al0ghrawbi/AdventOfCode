package dayTwo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
	static String[] split;
	public static int valid;
	public static ArrayList<Datensatz> liste;
	
	
	public static void main (String[] args){
		readFile();
		//countLetters();
		checkPasswort(); // Part 1, Policy: Buchstabe muss im PW zwischen x und y mal enthalten sein
		checkPolicy();// Part 2, Policy: Passwort darf entweder an Position x oder y enthalten sein (kein index zero, XOR)
	}
	/*
	public static void printListe(){	//fuer Testzwecke
		for(int x = 0;x<liste.size(); x++ ){
			System.out.println("Niedrigste Zahl:" +liste.get(x).getLow()+", hoechste Zahl: "+liste.get(x).getHigh()+ 
					", Feld[1]: "+liste.get(x).getFeld2()+ ", Feld[2]: "+liste.get(x).getFeld3() + "; Anzahl Vorkomnisse: "+liste.get(x).getLetterCount());
		}
		
	}
	*/ 
	
	
	public static void fillDatensatz(String data){
		split = data.split(" ");
		int count = 0;
		Datensatz eins = new Datensatz();
		eins.setFeld1(split[0]);
		eins.setFeld2(split[1]);
		eins.setFeld3(split[2]);
		
		for(int i = 0; i<split[2].length(); i++){
			if((eins.getFeld3().charAt(i))==(eins.getFeld2())){
				//System.out.println("getFeld2: " + eins.getFeld2() + "\ngetFeld3: "+ eins.getFeld3().charAt(i));
				count++;
			}
		}
		eins.setLetterCount(count);
		//System.out.println("Setze count: "+count);
		liste.add(eins);
	}
	
	public static void readFile(){
		liste = new ArrayList<Datensatz>();			
		Scanner scan = null;
		try{
			
			scan = new Scanner(new File("C:/Users/Graubi/Documents/AdventOfCode/inputZwei.txt"));
			
		} catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
			while(scan.hasNext()){
				//System.out.println(scan.nextLine());
				fillDatensatz(scan.nextLine());
				
			}
			scan.close();
			//printListe();
	
		
	
	}
	/*
	public static void countLetters(){ //nur zu Testzwecken, irrelevant
		
		String str = "aaabbbcccddde";
		char a = 'e';
		int count = 0;
		
		for(int x = 0; x<str.length(); x++){
			if(str.charAt(x) == a){
				count++;
			}
		}
		System.out.println(a + " ist "+ count+" mal in "+str+" enthalten.");
		
	}
	*/
	
	public static void checkPasswort(){
		int ergebnis = 0;
		
		for (int x = 0; x<liste.size(); x++){
			if((liste.get(x).getLetterCount() >= liste.get(x).getLow()) && (liste.get(x).getLetterCount() <= liste.get(x).getHigh())){
				ergebnis++;
			}
			// wenn er zwischen getLow und getHigh liegt, dann erhoehe valid +1
			
			
		}
		System.out.println("Akzeptierte Passwörter: "+ergebnis);
	}

	
	public static void checkPolicy(){ //hä lol hat irgendwie funktioniert amk
		int ergebnis = 0;
		int high = 0;
		int low = 0;
		char token;
		String pw;
		int length = 0;
		
		for (int x = 0; x<liste.size(); x++){
			high = liste.get(x).getHigh();
			low = liste.get(x).getLow();
			token = liste.get(x).getFeld2();
			pw = liste.get(x).getFeld3Adv();
			length = liste.get(x).getFeld3().length(); //nicht das manipulierte nehmen, laenge sonst verfaelscht
			
			if((high <= length) || (low <= length)){
			
				if((token == pw.charAt(low)) ^ (token == pw.charAt(high))){
				ergebnis++;
				}
			}
			System.out.println("low "+pw.charAt(low));
			System.out.println("high "+pw.charAt(high));
			System.out.println("Passwort: "+pw+", Token: "+token+", niedrigster Index: "+low+", hoechster Index: "+high+", Ergebnis: "+ergebnis);
			
		
		System.out.println("Akzeptierte Passwörter nach neuem System: "+ergebnis+"\n");
		
		}	
	}
}
