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
public class Cloud {
    private UUID cloudId;
    private WeatherReport weatherReport;
    private int allall;
}
