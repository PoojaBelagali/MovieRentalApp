package com.etraveli.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Customer {
    private String membershipId;
    private String name;
    @Builder.Default
    private Map<String , Integer> rentals =  new HashMap<>();
}
