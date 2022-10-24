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
public class Sys {
    private UUID sysCaptureId;
    private long type;
    private long id;
    private String country;
    private long sunrise;
    private long sunset;
}
