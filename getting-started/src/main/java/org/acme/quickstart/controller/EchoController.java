package org.acme.quickstart.controller;

import org.acme.quickstart.service.EchoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class EchoController {

    @Inject
    public EchoService echoService;

    @GET
    @Path("/echo/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String index(@PathParam("name") String name){
        return echoService.echo(name);
    }
}
