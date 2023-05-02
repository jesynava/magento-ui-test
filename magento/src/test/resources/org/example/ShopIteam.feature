Feature: As new customer I want to buy a product 

 Scenario Outline: Select an iteam and add it to shopping car
 		
 		Given I am on the department <department> 
   	When Selecting an item from <category> menu iteam <iteam>
    When Select a random item from cataloge size <size>
     
   
  	Examples:
  	|department		| category 						| iteam 		|size|
  	|Women				|Tops								  |Jacket		  |M   |
   	|Men					|Tops									|Tank				|S   |
   	|Women				|Bottom							  |Shorts			|28   |
   	|Gear     		|Fitness Equipment    |Cardio     ||
   
   
   