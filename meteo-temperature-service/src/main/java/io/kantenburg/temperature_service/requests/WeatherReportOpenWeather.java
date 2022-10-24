package io.kantenburg.temperature_service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class WeatherReportOpenWeather {
    private Coord coord;
    private String base;
    private OpenWeatherMain main;
    private int visibility;
    private OpenWeatherWind wind;
    private OpenWeatherCloud clouds;
    private long dt;
    private OpenWeatherSys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}
