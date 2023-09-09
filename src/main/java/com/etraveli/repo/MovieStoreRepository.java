package com.etraveli.repo;

import com.etraveli.dto.Customer;
import com.etraveli.dto.Movie;

import java.util.HashMap;
import java.util.Map;

/*
Can be extended as repository once the Database connection is established
 */
public class MovieStoreRepository {

    final Map<String, Customer> customerDirectory = new HashMap<>();

    final Map<String, Movie> movieDirectory = new HashMap<>();

    /*
    Helps to add new movie
     */
    public Movie addMovie(Movie movie) {
        return movieDirectory.put(movie.getCode(), movie);
    }


    /*
    Add new customer data to storage
     */
    public Customer addCustomer(Customer customer) {
        return customerDirectory.put(customer.getMembershipId(), customer);
    }


    /*
    Fetched the movie based on Id
     */
    public Movie getMovie(String movieId) {
        return movieDirectory.get(movieId);
    }

    /*
    Gets customer data from storage by customer id
     */
    public Customer getCustomer(String customerId) {
        return customerDirectory.get(customerId);
    }

}
