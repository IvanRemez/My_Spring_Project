package com.cydeo.client;

import com.cydeo.dto.weather.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherApiClient {

// http://api.weatherstack.com/current?access_key=cc698bac0852eda846f598eec37ef907&query=London

    @GetMapping("/current")
    WeatherDTO getCurrentWeather(@RequestParam(value = "access_key") String accessKey,
                                 @RequestParam(value = "query") String city);

}
