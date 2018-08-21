# LibertyGlobal
Once u checkout the repository. Import the project as Maven project. All the necessary dependency jars will be downloaded automatically.
Once it imports all the jars go to "SpringBootApplication.java" and run as "java application". 
Note:No need to do server setup as I am using springboot and springboot internally uses tomcat server so we can run this application as 
standalone.

I have tested the API using POSTMAN( To install POSTMAN app can refer "https://www.getpostman.com/apps" link)
1. To add potato bag to the market,
Step1: In POSTMAN, provide url "http://localhost:8080/potatobag" 
	   Select "POST" 	
	   Provide header in Headers section: KEY = Content-Type and VALUE=application/json.
Step2: Provide Body By adding potato details like:
		{
			"noOfPotato": 80,
			"supplier": "De Coster",
			"price": 50
		}
Step 3: Click on Send
Step4: You will recieve a message "PotatoBag successfully insterted" if provided input is proper. 
Validation: If noOfPotato is not between 1 and 100 or price is not from 1 to 50 or Supplier name is not one among "De Coster","Owel",
"Patatas Ruben","Yunnan Spices" then, data will not be insterted and throws same exception on POSTMAN screen.

2. To get list of potato Bags.
a. When we don't provide optional argument(by default 3 records will be fetched. If existing record is less than 3 then maximum 
records will be fetched)
Step1: In POSTMAN, 
	provide url "http://localhost:8080/potatobags?noOfPotatoBags"  OR "http://localhost:8080/potatobags"
	Select "GET"
	Click on Send.
	Records will be displayed in POSTMAN screen.
	
b. When we provide optional argument.
Step1: In POSTMAN,
	provide url: 	 (where N is the number of potato bags you want to fetch)
	Select "GET"
	Click on Send.
	N number of records will be retirved. (If number of records saved is less than N, then available number of records are fetched. 
  Eg if N=5 and only 4 records are present then only 4 records will be displayed)
