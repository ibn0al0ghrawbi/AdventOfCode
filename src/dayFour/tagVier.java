package dayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class tagVier {

	public static ArrayList<String> loadFile;
	public static ArrayList<String> summedPassports;
	public static ArrayList<String> validPassports;
	public static ArrayList<String> partTwo;


	
	public static void main(String[] args) {
		loadFile();
		
		convert();
		toObject();
		//printList(loadFile);
		System.out.println("Size validList: "+partTwo.size());
		//System.out.println(toObject());
		//checkDouble("eyr:");
		
	}
	
	
	public static void loadFile() { //loading and scanning puzzle input

		loadFile = new ArrayList<String>();
		Scanner scan = null;
		
		try {
			
			scan = new Scanner(new File("C:/Users/Graubi/eclipse-workspace/AdventOfCode/puzzleInput/tag4.txt"));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()) {
			loadFile.add(scan.nextLine());
		}
		loadFile.add(""); //adding and empty line after the last line, that my recursion in toObject() works for the last passport
		scan.close();
		
	}
	
	
	public static void printList(ArrayList<String> list) {	//printing purposes
		int count = 0;
		for (int column = 0; column<list.size(); column++) {
			
			System.out.println(list.get(column));
		}
		
	}
	
	
	public static Integer toObject() {
		int validPp = 0;
		validPassports = new ArrayList<String>();
		partTwo = new ArrayList<String>(); //unschoen, aber schnelle Loesung
		
		for(int column = 0; column < summedPassports.size(); column++) { //checking for the required fields in the summed up passports
			
			if((summedPassports.get(column).contains("byr:")&&(summedPassports.get(column).contains("iyr:")&&(summedPassports.get(column).contains("hgt:")&&(summedPassports.get(column).contains("hcl:")
					&&(summedPassports.get(column).contains("ecl:")&& (summedPassports.get(column).contains("pid:")) && (summedPassports.get(column).contains("eyr:")))))))) {
				validPp++;	//count valid passport up if found
				
				//for part 2:
				partTwo(summedPassports.get(column).toString());
				
				validPassports.add(summedPassports.get(column));
				//System.out.println(summedPassports.get(column).indexOf("byr:")+"\n");
			}
			
		}
		return validPp;
		
	}
	

	
	public static void partTwo(String passport) {	//checke nach jeder Eigenschaft, erhoehe count wenn gueltig, am Ende min 7 valid (cid faellt weg)
		String[] checkFile;
		checkFile = passport.split(" ");
		
		String[] inhalt;
		int count = 0;
		
		/*
		for(int x = 0; x<checkFile.length; x++) {
			System.out.println("x: "+x+", "+checkFile[x]+", laenge: "+checkFile[x].length());
		}
		System.out.println("\n");
		 */ 
		
		for(int i = 0; i<checkFile.length; i++) {
			inhalt = checkFile[i].split(":");
			
			/*for(int x = 0; x<inhalt.length; x++) {		//test purposes
				System.out.println("Inhalt: "+x+", "+inhalt[x]+", laenge: "+inhalt[x].length());
			}
			System.out.println("\n");
			 */
			
			for(int j = 0; j<inhalt.length-1; j++) {

			if(inhalt[0].contains("byr")) {
				
				if(inhalt[1].length() == 4 && (inhalt[1].matches(".*\\d.*")) //wenn zahl enthalten && lenge 4 && zwischen 1920 && 2002
						&& ((Integer.parseInt(inhalt[1])>=1920) && (Integer.parseInt(inhalt[1])<=2002))){
							count++;
							//System.out.println("Valid!: "+inhalt[0]+": Inhalt:"+inhalt[1]);
						}
				
			}else if(inhalt[0].contains("iyr")) { //wenn zahl enthalten && lenge 4 && zwischen 2010 && 2020

				if(inhalt[1].length() == 4 && (inhalt[1].matches(".*\\d.*")) //wenn zahl enthalten && lenge 4 && zwischen 1920 && 2002
						&& ((Integer.parseInt(inhalt[1])>=2010) && (Integer.parseInt(inhalt[1])<=2020))){
							count++;
							
						}
				
			}else if(inhalt[0].contains("eyr")){ //wenn zahl enthalten && lenge 4 && zwischen 2020 && 2030
				
				if(inhalt[1].length() == 4 && (inhalt[1].matches(".*\\d.*")) //wenn zahl enthalten && lenge 4 && zwischen 1920 && 2002
						&& ((Integer.parseInt(inhalt[1])>=2020) && (Integer.parseInt(inhalt[1])<=2030))){
							count++;
						}
				
			}else if(inhalt[0].contains("hgt")){
				int cmIndex = inhalt[1].indexOf("cm"); //index wo "cm" beginnt
				int inIndex = inhalt[1].indexOf("in"); //index wo "in" beginnt
				
				//System.out.println("Hoehe in cm: "+cmIndex+" ["+inhalt[1]+"]");
				//System.out.println("Hoehe in inch: "+inIndex+" ["+inhalt[1]+"]");
			
				if(cmIndex != -1) { //wenn cm
					
					String numberSub = inhalt[1].substring(0, cmIndex); //nimm substring von 0 - (cm-1)
					
					int height = Integer.parseInt(numberSub); 		//mach nummer draus
					if(height>=150 && height<=193) { 				//checke nummer gueltigkeit
						count++;
						
					}
					
				} else if(inIndex != -1) { //wenn in
					
					String numberSub = inhalt[1].substring(0, inIndex); //nimm substring von 0 - (in-1)
					
					int height = Integer.parseInt(numberSub); 		//mach nummer draus
					if(height>=59 && height<=76) { 				//checke nummer gueltigkeit
						count++;
						
					}
				}
				
			}else if(inhalt[0].contains("hcl")){ 
				
				if((inhalt[1].indexOf('#')==0)&&(inhalt[1].length()==7) 
						&&(inhalt[1].substring(1, inhalt[1].length()-1).matches("[0-9A-Fa-f]+"))) {	//wenn # das erste Zeichen ist und gesamtlaenge 7 und string ab # hexadez ist
					count++;
					
				}
				
			}else if(inhalt[0].contains("ecl")){ //wenn augenfarbe exakt eins aus der auswahl matched (XOR)
				String str = inhalt[1];
				if(str.equals("amb") ^ str.equals("blu") ^ str.equals("brn") ^ str.equals("gry") ^ 
						str.equals("grn") ^ str.equals("hzl") ^ str.contentEquals("oth")) {
					count++;
				}
				
			}else if(inhalt[0].contains("pid")){ //wenn 9-digit number (auch fuehrende 0)
				if((inhalt[1].length() == 9) && (inhalt[1].matches(".*\\d.*"))){
					count++;
				}
				
			}else if(inhalt[0].contains("cid")){ //optional, ignorieren
				
			}
		}
		
		
		}
		if(count==7) {	//wenn passport alle 7 kriterien erfuellt, adde zur neuen Liste
			System.out.println(passport+"\n");
			partTwo.add(passport);
		}else if(count<=7) {
			System.out.println("INVALID: ____"+passport+"_____INVALID\n");
		}
		
		
	}
	
	
	public static void convert() {	
		summedPassports = new ArrayList<String>();
		
		for(int column = 0; column<loadFile.size(); column++) {
			if(loadFile.get(column).isEmpty()) { //check if line is empty (so check if there is an empty space between two passports)
				
				summedPassports.add(rec(loadFile.get(column-1), column-1)); //if so, call the line before in the recursive function, and add the summed up passport to the new list
				
			}
								
		}
		
	}
	
	
	public static String rec (String str, int index) {	//recursive function to sum up passports which are spreaded over several lines into one line
		StringBuilder passportSum = new StringBuilder();

		if(!str.isEmpty() && index>=1) { //>=1 is necessary that the index won't get -1
			passportSum.append(str+" " + rec(loadFile.get(index-1), index-1));
			//System.out.println("Rekursion: "+gesamt.toString()+", Index: "+index);
			return passportSum.toString();
		} //append as long as the line is not empty (so as long as it is the same passport)
		
		
		return str;
	}
	
	//testing reasons
	public static void checkDouble(String code) {
		String textArray[];
		boolean flag = false;
		int count = 0;
		
		for (int x = 0; x<validPassports.size();x++) {
			textArray = validPassports.get(x).split(" ");
			for(int i = 0; i<textArray.length; i++) {
				
				if(textArray[i].contains(code)) {
					flag = true;
					count ++;
				}
			}
			if(flag) {
				System.out.println(validPassports.get(x) + "Number of occurences: "+count);
			}else {
				//System.out.println(x + "- Nichts doppelt - ");
			}
		}
		
		
	}
	
	
	
}
