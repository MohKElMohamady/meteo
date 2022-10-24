package io.kantenburg.temperature_service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
public class OpenWeatherCloud {
    private int all;
}
