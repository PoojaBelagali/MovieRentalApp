# Statement generation for Movie rental for a customer



Renamed the project as MovieRentalApp

1.Firstly, packaging is done for the project such as controller, service, dto, repo and util
2. Added MovieRentalApp class - It's a main class/starter point of MovieRenatl app is the one which will help us to test the  statement generation for customer for movies rented

3. DTO package has the model classes for customer, movie, movie rental and billing data
4. MovieType is an enum which holds categories of movie like Regular, Children and New. Can be added new ones in the future
5. Applied Interface segregation principle i.e. Service package holds the business logic of adding new customer, adding new movie, calculating bill/statement for movies rented by customer
6. MovieStoreRepository is the class acts like storage for customer and movie data, which can be extended in future for Database
7. MovieRentalController – Added controller has APIS for 
      a. Getting Statement - /movie-rental/statement
      b. Add Customer - /movie-rental/add-customer
      c. Add movie - /movie-rental/add-movie
     d. Rent a movie - /movie-rental/rent-movie
     Above APIs are exposed client and can be tested from postman

8. Added Billing data pojo for holding response about statement/ bill data
9. Restructred business logic of calculating the statement and added the corner scenarios to handle to exceptions such as null pointer excpetions.
   Segregated the logic into separate methods to calculate the statements for each movie category, replaced if/else statements into switch statement to          look code cleaner.
   
   Segregated logic of calculating the amount and frequency points.
10. Moved string concatenation with String Builder




## To run the test:

```
javac src/*.java
java -cp src Main
```
