package dayOne;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;



public class kalender {

	public static ArrayList<Integer> liste;
	
	public static void main (String[] args){
		ladeDatei();
		sucheDreiZahlen();
	}
	
	public static void ladeDatei(){
		liste = new ArrayList<Integer>();
		
		Scanner scan = null;
		try{
			scan = new Scanner(new File("C:/Users/Graubi/eclipse-workspace/AdventOfCode/puzzleInput/tag1.txt")); // PFad aufpassen
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
			while(scan.hasNext()){
				//System.out.println(scan.nextLine());
				liste.add(Integer.parseInt(scan.nextLine()));
			}
	scan.close();
	
	for (int x = 0; x<liste.size(); x++){
		System.out.println("Liste: "+liste.get(x));
	}
	
	}
	
	public static void sucheZahl(){  //zwei zahlen
		int sum;
		int var1 = 0;
		int var2 = 0;
		
		for(int x = 0; x<liste.size(); x++){
			for (int y = x+1; y<liste.size(); y++){
				sum = liste.get(x) + liste.get(y);
				if (sum == 2020){
					System.out.println("Bingo! "+liste.get(x)+ "(Index: "+x + ") + " + liste.get(y)  +" (Index "+y+") "+ "ergibt 2020");
					var1 = liste.get(x);
					var2 = liste.get(y);
					break;
				}
			}
			
		}
		System.out.println("Die beiden Summanden (" + var1+", "+ var2 + ") miteinander multipliziert ergeben: "+(var1 * var2));
	}
	
	
	public static void sucheDreiZahlen(){
		int sum;
		int var1 = 0;
		int var2 = 0;
		int var3 = 0;
		
		for (int x = 0; x<liste.size(); x++){
			for (int y = x+1; y<liste.size(); y++){
				for (int z = y+1; z<liste.size(); z++){
					sum = liste.get(x)+liste.get(y)+liste.get(z);
					if(sum == 2020){
						System.out.println("Bingo! "+liste.get(x)+ " (Index: "+x + ") + " + liste.get(y)  
						+" (Index "+y+") "+ "+ " + liste.get(z)+" (Index "+z+") ergibt 2020");
						var1 = liste.get(x);
						var2 = liste.get(y);
						var3 = liste.get(z);
						break;
					}
				}
			}
		}
		System.out.println("Die drei Summanden (" + var1+", "+ var2 + ", " +var3+ ") miteinander multipliziert ergeben: "+(var1 * var2 * var3));
	}
}
