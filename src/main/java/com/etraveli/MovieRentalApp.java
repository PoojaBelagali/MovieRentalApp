package com.etraveli;

import com.etraveli.service.MovieRentalServiceImpl;
import com.etraveli.util.MovieType;

public class MovieRentalApp {

  public static void main(String[] args) {

    //String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
    MovieRentalServiceImpl service = new MovieRentalServiceImpl();
    addCustomers(service);
    addMovies(service);
    rentMovies(service);

    System.out.println(service.getStatement("CUST-001"));




    //String result = new RentalInfo().statement(new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

   /* if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success  - Movie rented cost \n "+result );*/
  }

  private static void addCustomers(MovieRentalServiceImpl service) {
    service.addCustomer("CUST-001","Jhon Cena");
    service.addCustomer("CUST-002","Machael Roy");
    service.addCustomer("CUST-003","Arun Patel");
    service.addCustomer("CUST-004","Priyanka C");
    service.addCustomer("CUST-005","Rohan Kumar");

  }

  private static void addMovies(MovieRentalServiceImpl service) {
    service.addMovie("MOV-001","Star Wars", MovieType.REGULAR);
    service.addMovie("MOV-002","John Wick-4", MovieType.NEW);
    service.addMovie("MOV-003","Kung-Fu Panda-2", MovieType.CHILDREN);
    service.addMovie("MOV-004","Bridget Jones's Diary", MovieType.REGULAR);
    service.addMovie("MOV-005","Barbie", MovieType.NEW);
    service.addMovie("MOV-006","Frozen", MovieType.CHILDREN);
    service.addMovie("MOV-007","When Harry Met Sally", MovieType.REGULAR);
    service.addMovie("MOV-008","Oppenheimer", MovieType.NEW);
    service.addMovie("MOV-009","Wall-e", MovieType.CHILDREN);

  }

  private static void rentMovies(MovieRentalServiceImpl service) {
    service.rentMovie("CUST-001","MOV-002", 2);
    service.rentMovie("CUST-001","MOV-004", 4);
    service.rentMovie("CUST-001","MOV-006", 1);
    service.rentMovie("CUST-001","MOV-003", 5);
    service.rentMovie("CUST-001","MOV-008", 3);
    service.rentMovie("CUST-001","MOV-001", 2);

  }
}
