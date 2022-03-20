package org.acme.quickstart.service;



import io.quarkus.arc.properties.IfBuildProperty;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class WeatherAutoConfiguration {



    @Produces
    @IfBuildProperty(name="weather.enable",stringValue = "true")
    public WeatherService weatherService(WeatherProperties properties) {
        return new WeatherService(properties);
    }
}
