package io.kantenburg.temperature_service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
public class OpenWeatherSys {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}
