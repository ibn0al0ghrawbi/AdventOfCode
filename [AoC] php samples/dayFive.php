<?php

class dayFive{
	
	public $ergebnis;
	
	//will add an empty line at the end, but not necessary to delete this time
	function read(){
		$handle = fopen("G:/Dokumente/eclipse-workspace/AdventOfCode/puzzleInput/tag5.txt", "r");
		
		$this->ergebnis = array();
		
		if($handle){
		$i = 0;
			
			while(!feof($handle)){
			
			$inhalt = fgets($handle);  //reads a line from the position of the pointer
				$this->ergebnis[$i] = trim($inhalt);	//write content into array at position i //"this" to override the global array!! //trim to remove whitespace
				$i++;	
				
			}
			//array_pop($this->ergebnis); //delete last line of array, bcs it will be empty
			fclose($handle);
			
		
		}
		
	}
	
	
	function printInput(){
		
		foreach($this->ergebnis as $zeile){
			
			echo $zeile." ".strlen($zeile)."<br>";
			
		}	
	}
	
	function getMaxNumber(){
		$maxValue = array();
		$row;
		$seat;
		
		
		
		foreach($this->ergebnis as $passenger){
			
				//echo (substr($passenger, 0, -3))." | ";	 
				//echo (substr($passenger, -3))." = ";		
			$row = $this->recSearch(substr($passenger, 0, -3)); //substring of the rows
			$seat = $this->recSearch(substr($passenger,-3)); //substring of the seats (according to puzzle input)
			
			//echo "Row: ".$row.", Seat: ".$seat."<br><br>";
			//echo (($row * 8) + $seat)."<br>";
			array_push($maxValue, (($row * 8) + $seat) );
		}
		echo '<h1><center><span style="color:#59B675;style="font-family:Arial Black;"><br><br>--->Highest seat ID: ['.max($maxValue)."]<---<br><br><br><br>".' </h1></span>';
		$this->lastSpace($maxValue);
		
	}
	
	function recSearch(String $passenger){
		
		
		if (strlen($passenger) === 0) return false; //if array empty
		$ergebnis;
		$low = 0;
		$maxCount = 2 ** (strlen($passenger))-1;  
		
		
		$searchArr = range(0, $maxCount); //fill array with 128 or 8 values (rows or seats)
		
		
		
		while ($low < $maxCount){
		
			for($x = 0; $x <= strlen($passenger)-1; $x++){
		
			
		

		
				$mid = floor(($low + $maxCount) /2);
		
				if($passenger[$x] == 'L' || $passenger[$x] == 'F' ){ //search in the lower part
				
					$searchArr = array_slice($searchArr, $low, $mid+1);
				
					$maxCount = $mid;
					
				
				} else if ($passenger[$x] == 'R' || $passenger[$x] == 'B'){ //search in the higher part
						
						$searchArr = array_slice($searchArr, $mid+1, $maxCount);
						$low = $mid + 1;
						
				}
				$ergebnis = $low;
			}
		}
		
		//echo "Ergebnis: ".$ergebnis."<br><br>"; 
		return $ergebnis;
	}
	
	
	
	function lastSpace(Array $maxValue){
		
		//sort with bubblesort but not necessary
		/*
		for($i = 0; $i<count($maxValue); $i++){
		
			
			for($j = 0; $j<count($maxValue)-1;$j++){
				
				if($maxValue[$j]>$maxValue[$j +1]){	
				$temp=$maxValue[$j];
				$maxValue[$j]=$maxValue[$j+1];
				$maxValue[$j+1]=$temp;
				
				}
			}
		}
		*/
		/*foreach($maxValue as $line){	//printing purposes
		
			echo $line."<br>";
		}
		*/
		
		
		
		$arr2 = range(8, max($maxValue));
		
		$missing = array_diff($arr2, $maxValue); //array_diff keeps the key...
			
		$var = array_values($missing); //..so i take the value of the key and store it in an new array at 0
		
		$var2 = $var[0]; //get value 
		
		echo ('<h1><center><span style="color:#59B675;style="font-family:Arial Black;"><br><br>--->Missing ID: ['.$var2."]<---<br><br><br><br>".' </h1></span>');
	
		
		
		
	}
	
}

$dayFive = new dayFive();

$dayFive -> read();
//$dayFive -> printInput();
$dayFive -> getMaxNumber();

?>