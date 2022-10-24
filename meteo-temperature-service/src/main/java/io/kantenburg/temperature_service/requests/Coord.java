package io.kantenburg.temperature_service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
public class Coord {
    private double lon;
    private double lat;
}
