package com.etraveli.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class BillingData{
    String title;
    Double cost;
    Integer frequencyPoint;
}
