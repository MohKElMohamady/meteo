package io.kantenburg.meteo_gateway.controllers;

import io.kantenburg.meteo_gateway.models.WeatherReport;
import io.kantenburg.meteo_gateway.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @QueryMapping
    public WeatherReport weatherReportByCity(@Argument String city){
        return weatherService.weatherReportByCity(city);
    }

    @QueryMapping
    public WeatherReport weatherReportByLongitudeAndLatitude(@Argument double longitude, @Argument double latitude){
        return weatherService.weatherReportByLongitudeAndLatitude(longitude, latitude);
    }
}
