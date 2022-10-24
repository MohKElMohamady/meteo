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
public class Wind {
    private UUID windCaptureId;
    private WeatherReport weatherReport;
    private double speed;
    private long deg;
}
