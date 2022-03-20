package org.acme.quickstart.controller;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.acme.quickstart.service.WeatherService;
import org.jboss.resteasy.plugins.providers.ReactiveStreamProvider;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/api")
public class WeatherController {

    @Inject
    public WeatherService weatherService;

    @GET
    @Path("/currentcity")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> printCity() {
        return weatherService.printCity();
    }

    @GET
    @Path("/weather")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> weatherOfCity() throws Exception {

        return weatherService.getCityWeather();
    }

    @GET
    @Path("/weather/{city}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> weatherOfCity(@PathParam("city") String city) throws Exception {

        return weatherService.getCityWeather(city);
    }

}
