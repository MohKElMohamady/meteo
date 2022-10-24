package io.kantenburg.temperature_service.requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@RequiredArgsConstructor
public class OpenWeatherMain {
    private double temp;
    @JsonAlias(value = "feels_like")
    private double feelsLike;
    @JsonAlias(value = "temp_min")
    private double tempMin;
    @JsonAlias(value = "temp_max")
    private double tempMax;
    private int pressure;
    private int humidity;
}