package io.kantenburg.meteo_gateway.services;



import io.kantenburg.meteo_common.MeteoTemperatureServiceGrpc;
import io.kantenburg.meteo_common.City;
import io.kantenburg.meteo_gateway.models.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class WeatherService {
    @GrpcClient(value = "meteo-temperature-service")
    private MeteoTemperatureServiceGrpc.MeteoTemperatureServiceBlockingStub weatherStub;


    public WeatherReport weatherReportByCity(String city){
        City cityRequest = City.newBuilder().setCityName(city).build();

        var w = weatherStub.getWeatherByCity(cityRequest);

        var co = Coordinates.builder()
                .latitude(w.getCoordinates().getLatitude())
                .longitude(w.getCoordinates().getLongitude())
                .build();
        var sys = Sys.builder().id(w.getSys().getId())
                .type(w.getSys().getType())
                .country(w.getSys().getCountry())
                .sunrise(w.getSys().getSunrise())
                .build();
        var main = Main.builder()
                .temperature(w.getMain().getTemp())
                .feelsLike(w.getMain().getFeelsLike())
                .tempMin(w.getMain().getTempMin())
                .tempMax(w.getMain().getTempMax())
                .pressure(w.getMain().getPressure())
                .humidity(w.getMain().getHumidity())
                .build();
        var wind = Wind.builder()
                .speed(w.getWind().getSpeed())
                .deg(w.getWind().getDeg())
                .build();

        return WeatherReport.builder()
                .weatherReportId(UUID.randomUUID())
                .coordinates(co)
                .main(main)
                .visibility(w.getVisibility())
                .wind(wind)
                .sys(sys)
                .id(w.getId())
                .name(w.getName())
                .cod(w.getCod())
                .build();
    }

    public WeatherReport weatherReportByLongitudeAndLatitude(double longitude, double latitude){
        var coordinatesRequest = io.kantenburg.meteo_common.Coordinates.newBuilder()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .build();

        var w = weatherStub.getWeatherByCoordinates(coordinatesRequest);

        var co = Coordinates.builder()
                .latitude(w.getCoordinates().getLatitude())
                .longitude(w.getCoordinates().getLongitude())
                .build();
        var sys = Sys.builder().id(w.getSys().getId())
                .type(w.getSys().getType())
                .country(w.getSys().getCountry())
                .sunrise(w.getSys().getSunrise())
                .build();
        var main = Main.builder()
                .temperature(w.getMain().getTemp())
                .feelsLike(w.getMain().getFeelsLike())
                .tempMin(w.getMain().getTempMin())
                .tempMax(w.getMain().getTempMax())
                .pressure(w.getMain().getPressure())
                .humidity(w.getMain().getHumidity())
                .build();
        var wind = Wind.builder()
                .speed(w.getWind().getSpeed())
                .deg(w.getWind().getDeg())
                .build();

        System.out.println(w.toString());

        return WeatherReport.builder()
                .weatherReportId(UUID.randomUUID())
                .coordinates(co)
                .main(main)
                .visibility(w.getVisibility())
                .wind(wind)
                .sys(sys)
                .id(w.getId())
                .name(w.getName())
                .cod(w.getCod())
                .build();
    }

}
