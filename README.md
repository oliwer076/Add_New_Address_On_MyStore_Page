Selenium WebDriver + Cucumber

website "https://mystore-testlab.coderslab.pl."

-log in with a user you created manually,

-click on the Addresses tile after logging in (the address we should be at is: 
https://mystore-testlab.coderslab.pl/index.php?controller=addresses),

-click on + Create new address,

-fill in the New address form - the data should be taken from the Examples table in Gherkin 
(alias, address, city, zip/postal code, country, phone),

-verify that the data in the added address is correct,