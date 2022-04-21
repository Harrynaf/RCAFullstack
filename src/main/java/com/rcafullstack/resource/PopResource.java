package com.rcafullstack.resource;

import com.rcafullstack.service.DataPop;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/populate")
public class PopResource {

    @Inject
    private DataPop dataPop;

    @Path("/")
    @POST
    public void dataPop() {
        dataPop.run();
    }

}