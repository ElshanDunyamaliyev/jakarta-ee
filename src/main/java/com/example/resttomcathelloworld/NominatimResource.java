package com.example.resttomcathelloworld;

import com.example.resttomcathelloworld.service.NominatimService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/")
public class NominatimResource {

    @Inject
    NominatimService searchService;

    @GET()
    @Path("/search")
    @Produces("application/json")
    public Response search(@DefaultValue("baki") @QueryParam("q") String query) {
        return searchService.search(query);
    }

    @GET()
    @Path("/reverse")
    @Produces("application/json")
    public Response reverse(@DefaultValue("40.3755885") @QueryParam("lat") double lat,@DefaultValue("49.8328009") @QueryParam("lon") double lon) {
        return searchService.reverse(lat,lon);
    }
}