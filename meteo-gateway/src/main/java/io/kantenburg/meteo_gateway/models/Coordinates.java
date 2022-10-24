package io.kantenburg.meteo_gateway.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Coordinates {
    private double latitude;
    private double longitude;

}
class CoordinatesId implements Serializable {
    private double latitude;
    private double longitude;
}