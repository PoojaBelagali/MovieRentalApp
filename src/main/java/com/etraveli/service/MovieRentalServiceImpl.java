package com.etraveli.service;


import com.etraveli.dto.BillingData;
import com.etraveli.dto.Customer;
import com.etraveli.dto.Movie;
import com.etraveli.repo.MovieStoreRepository;
import com.etraveli.util.MovieType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class MovieRentalServiceImpl implements MovieRentalService {
    MovieStoreRepository dataStore = new MovieStoreRepository();

    @Override
    public String getStatement(String membershipId) {
        Customer customer = getCustomer(membershipId);
        if (customer == null) {
            // todo: raise exception for customer not found
            return null;
        }
        Map<String, Integer> rentalMap = customer.getRentals();
        List<BillingData> billingDataAll = rentalMap.entrySet().stream().map(this::calculateRent).collect(Collectors.toList());
        return generateStatementString(billingDataAll, customer.getName());
    }

    @Override
    public void rentMovie(String membershipId, String code, Integer days) {
        Customer customer = getCustomer(membershipId);
        if (customer == null) {
            // todo: raise exception for customer not found
            return;
        }
        Integer rentalDays = customer.getRentals().get(code);
        if (rentalDays != null) {
            days += rentalDays;
        }
        customer.getRentals().put(code, days);

    }

    @Override
    public Customer addCustomer(String membershipId, String name) {
        Customer customer = Customer.builder().membershipId(membershipId).name(name).build();
        return dataStore.addCustomer(customer);
    }

    @Override
    public Movie addMovie(String code, String name, MovieType type) {
        Movie movie = Movie.builder().code(code).title(name).type(type).build();
        return dataStore.addMovie(movie);
    }

    @Override
    public Customer getCustomer(String membershipId) {
        return dataStore.getCustomer(membershipId);
    }

    @Override
    public Movie getMovie(String code) {
        return dataStore.getMovie(code);
    }
    private String generateStatementString(List<BillingData> allMovieBilling, String name) {
        StringBuilder builder = new StringBuilder();
        Double sum = 0.0;
        Integer frequencyPoint = 0;
        builder.append("Rental Record for ");
        builder.append(name);

        for (BillingData item: allMovieBilling) {
            builder.append("\n\t").append(item.getTitle()).append("\t").append(item.getCost());
            sum += item.getCost();
            frequencyPoint += item.getFrequencyPoint();
        }

        builder.append("\nAmount owed is ").append(sum);
        builder.append("\nYou earned ").append(frequencyPoint).append(" frequent points\n");

        return builder.toString();
    }

    private BillingData calculateRent(Map.Entry<String, Integer>  movieRent) {
        Movie movie = dataStore.getMovie(movieRent.getKey());
        Integer days = movieRent.getValue();
        Integer freqPoints = calculateFrequencyPoint(movie.getType(), movieRent.getValue());
        Double calChargeMovie = 0.0;
        switch (movie.getType()) {
            case REGULAR:
                calChargeMovie =  calculatePriceForRegularMovie(days);
                break;

            case NEW:
                calChargeMovie =  (double) (days * 3);
                break;

            case CHILDREN:
                calChargeMovie =  calculatePriceForChildrenMovie(days);
                break;

            default:
                return null;


        }

        return BillingData.builder().title(movie.getTitle()).
                frequencyPoint(freqPoints).
                cost(calChargeMovie).build();
    }


    private double calculatePriceForChildrenMovie(Integer days) {
        Double moviePrice = 1.5;
        if (days > 3) {
            moviePrice +=  ((days - 3) * 1.5);
        }
        return moviePrice;
    }

    private double calculatePriceForRegularMovie(Integer days) {
        Double moviePrice = 2.0;
        if (days > 2) {
            moviePrice +=   ((days - 2) * 1.5) + moviePrice;
        }
        return moviePrice;
    }

    private Integer calculateFrequencyPoint(MovieType type, Integer days) {
        //add frequent bonus points
        Integer frequentEnterPoints = 1;
        // add bonus for a two day new release rental
        if (type == MovieType.NEW && days > 2) frequentEnterPoints++;

        return frequentEnterPoints;
    }


}
