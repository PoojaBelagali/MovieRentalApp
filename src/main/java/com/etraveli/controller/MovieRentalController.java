package com.etraveli.controller;


import com.etraveli.dto.Customer;
import com.etraveli.dto.Movie;
import com.etraveli.service.MovieRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie-rental")
@RequiredArgsConstructor
public class MovieRentalController {


    private final MovieRentalService movieRentalService;

    @RequestMapping(method = RequestMethod.POST, value = "/add-customer")
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
        return movieRentalService.addCustomer(customer.getMembershipId(), customer.getName());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-movie")
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRentalService.addMovie(movie.getCode(), movie.getTitle(), movie.getType());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rent-movie")
    public void rentMovie(@RequestParam String customerId, @RequestParam String movieCode, @RequestParam Integer  days) {
         movieRentalService.rentMovie(customerId, movieCode, days);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statement")
    @ResponseBody
    public String getStatement(@RequestParam String customerId) {
        return movieRentalService.getStatement(customerId);
    }


}
