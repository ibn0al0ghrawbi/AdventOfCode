<?php




class dayTwo{
	
	
	
	public $ergebnis; //global array of the puzzle input
	
	
	
	function read(){
	
		$handle = fopen("G:/Dokumente/eclipse-workspace/AdventOfCode/puzzleInput/tag2.txt","r");
		$this->ergebnis = array();
		
		if($handle){
		$i = 0;
			while(!feof($handle)){
				$inhalt = fgets($handle);  //reads a line from the position of the pointer
				$this->ergebnis[$i] = $inhalt;	//write content into array at position i //"this" to override the global array!!
				$i++;	
		
			}
			array_pop($this->ergebnis); //delete last line of array, bcs it will be empty
			fclose($handle);
		}
		
		
	}
	
	function print(){
		
		foreach($this->ergebnis as $zeile){
			
			echo $zeile."<br>";
		}
		
	}
	
	
	
	
	function extractPartOne(){
		
		$rangeCount; //passcode-policy as substring
		$getMin;		//min occurrence of key-letter
		$getMax;		//max occurrence of key-letter
		$occurrences;	//occurrences of the key letter within the passcode
		$countOcc = 0;
		
		foreach($this->ergebnis as $zeile){
			list($policy, $sub, $password) = array_pad(explode(' ', "$zeile "),3, null);  //splitting line into policy (i.e: 1-4), key-letter and passcode
			//echo $policy." ".$sub." ".$password."<br>";		//output
			
			$rangeCount = array_pad(explode('-', "$policy "),-2, 0);  //array_pad fills the array until it reaches a desired size. Needed to avoid offset error
			
			$getMin = $rangeCount[0];
			$getMax = $rangeCount[1];
			
			$occurrences = substr_count($password, rtrim($sub,': '),0); //count occurrences of $sub in $password beginning at pos 0 //rtrim to delete ":" after the substring, otherwise it doesnt find any occurrences
			
			
			if(($occurrences >= $getMin) && ($occurrences <= $getMax)){ //
				
				$countOcc++;
				echo "Valid line spotted: ".$zeile."<br>";
				
			}
			
		}
		
		echo '<h1><center><span style="color:#59B675;style="font-family:Arial Black;"><br><br>--->Valid Codes: ['.$countOcc."]<---<br><br><br><br>".' </h1></span>';
		
	}
	
	
	function extractPartTwo(){ //incomplete
		
		/*
		my basic idea: 
		search the char within the string and return all positions
		check with XOR if the conditions is fullfilled
		
		
		
		*/
		
		
	}
	
}
	
$day2 = new dayTwo();
$day2 -> read();
$day2 -> extractPartOne();


?>