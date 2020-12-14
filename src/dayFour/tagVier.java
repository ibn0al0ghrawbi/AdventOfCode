package dayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class tagVier {

	public static ArrayList<String> liste;
	public static ArrayList<String> neueListe;

	public static void main(String[] args) {
		loadFile();
		//printList(liste);
		convert();
		printList(neueListe);
		System.out.println(toObject());
	}
	
	
	public static void loadFile() {

		liste = new ArrayList<String>();
		Scanner scan = null;
		
		try {
			
			scan = new Scanner(new File("C:/Users/Graubi/eclipse-workspace/AdventOfCode/puzzleInput/tag4.txt"));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()) {
			liste.add(scan.nextLine());
		}
		scan.close();
		
	}
	
	
	public static void printList(ArrayList liste) {
		
		for (int column = 0; column<liste.size(); column++) {
			System.out.println(liste.get(column)+"\n");
			
		}
		
	}
	
	public static Integer toObject() {
		int gueltigerPp = 0;
		
		for(int column = 0; column < neueListe.size(); column++) {
				
				if((neueListe.get(column).contains("byr"))&&(neueListe.get(column).contains("iyr")&&(neueListe.get(column).contains("hgt")&&(neueListe.get(column).contains("hcl")
						&&(neueListe.get(column).contains("ecl")&& (neueListe.get(column).contains("pid"))))))) {
					//System.out.println("Gültiger Passport spottedin Spalte: "+column);
				gueltigerPp++;
				}
			
		}
		return gueltigerPp;
		
	}
	
	public static void convert() {
		neueListe = new ArrayList<String>();
		
		for(int column = 0; column<liste.size(); column++) {
			if(liste.get(column).isEmpty()) {
				
				neueListe.add(rec(liste.get(column-1), column-1));
			}
			
			
				
						
		}
		
	}
	
	public static String rec (String str, int index) {
		StringBuilder gesamt = new StringBuilder();

		if(!str.isEmpty() && index>=1) {
			gesamt.append(str+" " + rec(liste.get(index-1), index-1));
			//System.out.println("Rekursion: "+gesamt.toString()+", Index: "+index);
			return gesamt.toString();
		}
		
		
		return str;
	}
}
