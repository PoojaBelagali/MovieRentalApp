package com.etraveli.service;

import com.etraveli.dto.Customer;
import com.etraveli.dto.Movie;
import com.etraveli.util.MovieType;

public interface MovieRentalService {


     String getStatement(String membershipId);


     void rentMovie(String membershipId, String code, Integer days);

     Customer addCustomer(String membershipId, String name);

     Movie addMovie(String code, String name, MovieType type);

     Customer getCustomer(String membershipId);

     Movie getMovie(String code);


}
