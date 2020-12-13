package dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tagDrei {

	public static ArrayList<String> liste;
	public static char map[][];
	
	public static void main(String [] args) {
		
		loadFile();
		
		convert();
		
		slipping();
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
	
	public static void slipping() {
		
		int x=1;
		int y=3;
		int countTrees = 0;
		
		while(x<map.length) {
			
			if(map[x][y] == '#') {
				countTrees++;
				map[x][y] = 'X'; //replace a hitted tree with an zero for graphical representation
			}else if(map[x][y] == '.') {
				map[x][y] = '0';
			}
			x=x+1;
			y=(y+3)%31;
			
		}
		printArray();
		System.out.println("\nhitted trees: "+countTrees);
		
	}
}
