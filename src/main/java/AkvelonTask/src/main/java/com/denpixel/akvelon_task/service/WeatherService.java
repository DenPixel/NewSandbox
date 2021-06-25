package com.denpixel.akvelon_task.service;

import com.denpixel.akvelon_task.model.City;
import com.denpixel.akvelon_task.model.Weather;
import com.denpixel.akvelon_task.model.WeatherResponse;
import com.denpixel.akvelon_task.repository.CityRepository;
import com.denpixel.akvelon_task.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import javax.transaction.Transactional;
import java.net.URI;
import java.time.Instant;

@Service
@Transactional
public class WeatherService implements WeatherData {

    private static final String WEATHER_URI = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}&units=metric";

    @Value("${api.openweathermap.key}")
    private String API_KEY;

    private final WeatherRepository weatherRepository;
    private final CityRepository cityRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository,
                          CityRepository cityRepository,
                          RestTemplate restTemplate,
                          ObjectMapper objectMapper) {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        URI url = new UriTemplate(WEATHER_URI).expand(cityName, API_KEY);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        City city = cityRepository.findByName(cityName).orElseThrow();

        return convert(response, city);
    }

    private Weather getWeatherResponse(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Weather resp = null;
        String strBody = null;
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        try {
            resp = objectMapper.readValue(strBody, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    private WeatherResponse convert(ResponseEntity<String> response, City city) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());

            double temp = root.path("main").path("temp").asDouble();
            double feelsLike = root.path("main").path("feels_like").asDouble();
            double tempMin = root.path("main").path("temp_min").asDouble();
            double tempMax = root.path("main").path("temp_max").asDouble();
            double windSpeed = root.path("wind").path("speed").asDouble();
            String description = root.path("weather").get(0).path("description").asText();

            Weather weather = new Weather();

            weather.setTemperature(temp);
            weather.setFeelsLike(feelsLike);
            weather.setTemperatureMin(tempMin);
            weather.setTemperatureMax(tempMax);
            weather.setWindSpeed(windSpeed);
            weather.setDescription(description);
            weather.setCity(city);
            weather.setTimestamp(Instant.now());


            return WeatherResponse.weatherResponseFromWeather(weatherRepository.save(weather));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
