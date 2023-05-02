Feature: As new customer I want to buy a product end to end test

 Scenario Outline: Select a produt to buy and compleated the checkout process
 	 	Given I am on the department <department> 
   	When Selecting an item from <category> menu iteam <iteam>
    When Select a random item from cataloge size <size>
    And  Fill checkout and fill form with email as <email> name as <name> lastname as <lastname> street as <street> city as <city>
   
  	Examples:
  	|department		| category 						| iteam 		|size|email 				| name | lastname | street 		| city 	|
  	|Women				|Tops								  |Tees		  |L   |jessy@gmail.com|Jess  |Nava      |longStreet	|miami	|
  	
   