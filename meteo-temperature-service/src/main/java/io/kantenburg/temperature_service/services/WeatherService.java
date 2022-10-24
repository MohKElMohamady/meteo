package io.kantenburg.temperature_service.services;

import io.grpc.stub.StreamObserver;
import io.kantenburg.meteo_common.*;
import io.kantenburg.temperature_service.requests.WeatherReportOpenWeather;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Slf4j
@GrpcService
public class WeatherService extends MeteoTemperatureServiceGrpc.MeteoTemperatureServiceImplBase {
    @Value("${io.kantenburg.open-weather}")
    private String apiKey;

    @Override
    public void getWeatherByCity(City request, StreamObserver<WeatherReport> responseObserver) {
        var city = request.getCityName();
        String openWeatherAPIByCity = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&APPID="+ apiKey + "&mode=metric";
        WeatherReportOpenWeather weatherReportFromOpenWeatherAPI = WebClient.create()
                .get()
                .uri(openWeatherAPIByCity)
                .retrieve()
                .bodyToMono(WeatherReportOpenWeather.class)
                .block();
        Coordinates coordinates = Coordinates.newBuilder().setLongitude(weatherReportFromOpenWeatherAPI.getCoord().getLon())
                                                          .setLatitude(weatherReportFromOpenWeatherAPI.getCoord().getLat())
                                                          .build();
        Main main = Main.newBuilder()
                .setTemp(weatherReportFromOpenWeatherAPI.getMain().getTemp())
                .setFeelsLike(weatherReportFromOpenWeatherAPI.getMain().getFeelsLike())
                .setTempMin(weatherReportFromOpenWeatherAPI.getMain().getTempMin())
                .setTempMax(weatherReportFromOpenWeatherAPI.getMain().getTempMax())
                .setPressure(weatherReportFromOpenWeatherAPI.getMain().getPressure())
                .setHumidity(weatherReportFromOpenWeatherAPI.getMain().getHumidity())
                .build();
        Wind wind = Wind.newBuilder().setDeg(weatherReportFromOpenWeatherAPI.getWind().getDeg())
                .setSpeed(weatherReportFromOpenWeatherAPI.getWind().getDeg()).build();
        Sys sys = Sys.newBuilder()
                .setType(weatherReportFromOpenWeatherAPI.getSys().getType())
                .setId(weatherReportFromOpenWeatherAPI.getSys().getId())
                .setSunrise(weatherReportFromOpenWeatherAPI.getSys().getSunrise())
                .setSunset(weatherReportFromOpenWeatherAPI.getSys().getSunrise())
                .setCountry(weatherReportFromOpenWeatherAPI.getSys().getCountry())
                .build();
        WeatherReport weatherReport = WeatherReport.newBuilder()
                .setCoordinates(coordinates)
                .setMain(main)
                .setWind(wind)
                .setSys(sys)
                .setTimezone(weatherReportFromOpenWeatherAPI.getTimezone())
                .setId(weatherReportFromOpenWeatherAPI.getId())
                .setName(weatherReportFromOpenWeatherAPI.getName())
                .setCod(weatherReportFromOpenWeatherAPI.getCod())
                .build();
        responseObserver.onNext(weatherReport);
        responseObserver.onCompleted();
    }

    @Override
    public void getWeatherByCoordinates(Coordinates request, StreamObserver<WeatherReport> responseObserver) {
        var latitude = request.getLatitude();
        var longitude = request.getLongitude();
        String openWeatherAPIByCity = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon="+ longitude +"&appid=" + apiKey + "&mode=metric";
        WeatherReportOpenWeather weatherReportFromOpenWeatherAPI = WebClient.create()
                .get()
                .uri(openWeatherAPIByCity)
                .retrieve()
                .bodyToMono(WeatherReportOpenWeather.class)
                .block();
        Coordinates coordinates = Coordinates.newBuilder().setLongitude(weatherReportFromOpenWeatherAPI.getCoord().getLon())
                .setLatitude(weatherReportFromOpenWeatherAPI.getCoord().getLat())
                .build();
        Main main = Main.newBuilder()
                .setTemp(weatherReportFromOpenWeatherAPI.getMain().getTemp())
                .setFeelsLike(weatherReportFromOpenWeatherAPI.getMain().getFeelsLike())
                .setTempMin(weatherReportFromOpenWeatherAPI.getMain().getTempMin())
                .setTempMax(weatherReportFromOpenWeatherAPI.getMain().getTempMax())
                .setPressure(weatherReportFromOpenWeatherAPI.getMain().getPressure())
                .setHumidity(weatherReportFromOpenWeatherAPI.getMain().getHumidity())
                .build();
        Wind wind = Wind.newBuilder().setDeg(weatherReportFromOpenWeatherAPI.getWind().getDeg())
                .setSpeed(weatherReportFromOpenWeatherAPI.getWind().getDeg()).build();
        Sys sys = Sys.newBuilder()
                .setType(weatherReportFromOpenWeatherAPI.getSys().getType())
                .setId(weatherReportFromOpenWeatherAPI.getSys().getId())
                .setSunrise(weatherReportFromOpenWeatherAPI.getSys().getSunrise())
                .setSunset(weatherReportFromOpenWeatherAPI.getSys().getSunrise())
                .setCountry(weatherReportFromOpenWeatherAPI.getSys().getCountry())
                .build();
        WeatherReport weatherReport = WeatherReport.newBuilder()
                .setCoordinates(coordinates)
                .setMain(main)
                .setWind(wind)
                .setSys(sys)
                .setTimezone(weatherReportFromOpenWeatherAPI.getTimezone())
                .setId(weatherReportFromOpenWeatherAPI.getId())
                .setName(weatherReportFromOpenWeatherAPI.getName())
                .setCod(weatherReportFromOpenWeatherAPI.getCod())
                .build();
        log.info("{}", weatherReport);
        responseObserver.onNext(weatherReport);
        responseObserver.onCompleted();
    }
}
