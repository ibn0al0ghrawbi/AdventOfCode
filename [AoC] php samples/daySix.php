<?php

class daySix{

public $ergebnis;
public $globalCount;	
	
	
	//will add an empty line at the end, but not necessary to delete this time
	function read(){
		
		echo '<h1><center><span style="color:#00aaff;style="font-family:Arial Black;"><br><br><br>Scroll to end of page for the solution'."<br><br><br><br>".' </h1></span>';
		
		$handle = fopen("G:/Dokumente/eclipse-workspace/AdventOfCode/puzzleInput/tag6.txt", "r");
		
		$this->ergebnis = array();
		
		if($handle){
		$i = 0;
			
			while(!feof($handle)){ //while pointer not at end of file
			
				$inhalt = fgets($handle);  //reads a line from the position of the pointer
				$inhalt = trim($inhalt); //delete white spaces to later check for "empty lines"
					
					
				$this->ergebnis[$i] = trim($inhalt);	//write content into array at position i //"this" to override the global array!! //trim to remove whitespace
				$i++;	
				
			}
			
			fclose($handle);
			
		
		}
		
	}
	
	
	function printInput(){
		
		foreach($this->ergebnis as $zeile){
			
			echo $zeile."<br>";
			
		}	
	}


	function concatBlock(){
		
		$countCode = 0;		//count chars
		$blockString = "";	//concated string of a codeblock
		
		foreach ($this->ergebnis as $zeile){		//explore array
		
			//echo $zeile;
			if (!empty($zeile)){					//if line is not empty (so if you are within one code block)
				
				$blockString .= $zeile;				//concat the lines to one string
				
			
			} elseif (empty($zeile)){				//if line is empty 
				
			
				foreach (count_chars($blockString, 1) as $i => $val) {	//count all occurences of a char in the concated string, already counted chars will be skipped on next occurence within string
					//echo "Es gibt $val Vorkommen von \"" , chr($i) , "\" in der Zeichenkette.\n<br>";
					$countCode = $countCode+1;	//char-Counter +1
				}
		
				echo "String: ".$blockString.", overall once occouring chars yet: ";
				echo '<h3><center-left><span style="color:#ff1d0b;style="font-family:Arial Black;">['.$countCode."]<br><br><br><br>".' </h3></span>';
				$blockString = "";	//set string to zero for the next codeblock
				
			}
			//echo $blockString."<br>";	
		}
		
		
		return $countCode;
		
	}
	
	
}

$daySix = new daySix();
$daySix->read();
//$daySix->printInput();
echo ($daySix->concatBlock());

echo '<h1><center><span style="color:#00aaff;style="font-family:Arial Black;"> Summed up chars: ['.($daySix->concatBlock())."]<br><br><br><br>".' </h1></span>';


?>