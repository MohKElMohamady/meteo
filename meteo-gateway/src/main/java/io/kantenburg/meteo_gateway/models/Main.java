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
public class Main {
    private UUID temperatureCaptureId;
    private double temperature;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private long pressure;
    private long humidity;
}
