package dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class tagDrei {

	public static ArrayList<String> liste;
	public static char map[][];
	
	
	public static void main(String [] args) throws InterruptedException {
		
		loadFile();
		
		convert();
		//slipping(1,3);
		System.out.println(rechne());
		
	
		
	
	}
	
	public static long rechne(){
		long gesamt;
		long a = slipping(1,1);
		
		
		long b = slipping(1,3);
		
		long c = slipping(1,5);
		
		long d = slipping(1,7);
	
		long e = slipping(2,1);
		
		gesamt = a*b*c*d*e;
		return gesamt;
	}
	
	
	public static void loadFile() { 		//writing the file line by line into a string arraylist, bcs it was easier that way for me
		liste = new ArrayList<String>();
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("C:/Users/Graubi/eclipse-workspace/AdventOfCode/puzzleInput/tag3.txt"));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()) {
			
			liste.add(scan.nextLine());
			
		}
		scan.close();
	}
	
	
	public static void convert() { //converting the arraylist to a char double array
		int col = liste.size();
		map = new char[col][31];  //hard coding the rows bcs i know them safe
	
		for(int x = 0; x<col;x++) {
			for(int y = 0; y<31;y++) {
				map[x][y] = liste.get(x).charAt(y);
				
			}
		}
		
		
	}
	
	public static void printArray() {	//printing of the char double Array
		int col = liste.size();
		for(int x = 0; x<col;x++) {
			for(int y = 0; y<31; y++) {
				System.out.print(map[x][y]+" ");
			}
			System.out.println();
		}
	}
	
	public static Integer slipping(int down,int right) {
		convert();		//char array jedes mal neu initialisieren, da es sonst zu overflow fehlern in der berechnung mehrerer slips gibt
		int x=down;
		int y=right;
		int countTrees = 0;
		
		
		while(x<map.length) {
			
			if(map[x][y] == '#') {
				countTrees=countTrees+1;
				map[x][y] = 'X'; //replace a hitted tree with an zero for graphical representation
			}else if(map[x][y] == '.') {
				map[x][y] = '0';
			}
			x=x+down;
			y=(y+right)%31;
			
		}
		//printArray();
		System.out.println("\nhitted trees: "+countTrees);
		return countTrees;	
	
	}
}
