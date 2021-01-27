<h1><center> Welcome to Day 1 of the Advent of Code Challenge. </h1>


<h2><center> Let's get the puzzle-input.</h2>

<?php


class dayOne
{
public $ergebnis;
	
	
	public function read(){
	
	$handle = fopen("G:/Dokumente/eclipse-workspace/AdventOfCode/puzzleInput/tag1.txt", "r");
	$this->ergebnis = array();
	
	if($handle) 	//if handle exists
		{
			$i = 0; //set pointer position = 0
			while(!feof($handle)) //while pointer is not at the end of the line 
			{
				$inhalt = fgets($handle);  //reads a line from the position of the pointer
				$this->ergebnis[$i] = $inhalt;	//write content into array at position i //"this" to override the global array!!
				$i++;						//next position
				//echo($inhalt)."<br>\n"; //for testing purposes
			}
			fclose($handle);
		}
		
		
		
		
		
		
		
	}
	
	
	public function calculateTwo(){
		
		$multiply=0;
		
		for ($i=0; 	$i < count($this->ergebnis); $i++){
			for ($j = 1; $j < count($this->ergebnis)-1; $j++){
				
			
				//echo "i: ".$this->ergebnis[$i]."; j:".$this->ergebnis[$j]."<br>";
				
				if(intval($this->ergebnis[$i]) + intval($this->ergebnis[$j]) == 2020){
					
					echo '<span style="color:#FF0000;text-align:center;">Treffer!: '.$this->ergebnis[$i]."+".$this->ergebnis[$j]."<br>".' </span>';
					$multiply = intval($this->ergebnis[$i]) * intval($this->ergebnis[$j]);
					break 2; //break 2 loop levels if solution is found (bcs of double loop)
				}
				
				
			}
			
		}
		

	echo "<br>The two found numbers multiplied: ".$multiply."<br>";
		
		
	}
	
	
	public function calculateThree(){
		
		$multiply=0;
		
		for($i=0; $i < count($this->ergebnis); $i++){
			for($j = 1; $j < count($this->ergebnis)-1; $j++){
				for($k = 2; $k < count($this->ergebnis)-2; $k++){
						
						if(intval($this->ergebnis[$i]) + intval($this->ergebnis[$j]) + intval($this->ergebnis[$k]) == 2020){
							
						echo '<span style="color:#FF0000;text-align:center;"><br><br>Treffer!: '.$this->ergebnis[$i]."+".$this->ergebnis[$j]."+".$this->ergebnis[$k]."<br>".' </span>';
						$multiply = intval($this->ergebnis[$i]) * intval($this->ergebnis[$j]) * intval($this->ergebnis[$k]);
						break 3; //break 3 loop levels if solution is found (bcs of triple loop)
							
							
						}
						
					
				}
				
			}
			
		}
			echo "<br>The three numbers multiplied: ".$multiply."<br>";
		
	}
	
	
	public function print()	{ //add param?
	
	$i = 0;
		foreach ($this->ergebnis as $value){ //"this" to access global array!
		$i++;
		echo($value);
		
		
		if($i % 10 == 0){
			echo "<br>";
		}
		}
	
	
	}

}

$dayOne_1 = new dayOne();
$dayOne_1 -> read();
$dayOne_1 -> calculateTwo();
$dayOne_1 -> calculateThree();

?>
