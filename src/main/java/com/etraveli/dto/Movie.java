package com.etraveli.dto;

import com.etraveli.util.MovieType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private String title;
    private String code;
    private MovieType type;


}
