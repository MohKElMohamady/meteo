package io.kantenburg.meteo_gateway.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@Builder
@Data
@RequiredArgsConstructor
public class WeatherReport {
    private UUID weatherReportId;
    private Coordinates coordinates;
    private Main main;
    private long visibility;
    private Wind wind;
    private Sys sys;
    private double id;
    private String name;
    private long cod;
}
