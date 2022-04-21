package com.rcafullstack.resource;

import com.rcafullstack.model.Repair;
import com.rcafullstack.service.RepairService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/repair")
public class RepairResource {

    @Inject
    private RepairService repairService;

    @Path("/{repairId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Repair getRepair(@PathParam("repairId") long repairId){
        return repairService.get(repairId);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Repair saveRepair(Repair repair){
        return repairService.create(repair);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Repair updateRepair(Repair repair){
        return repairService.update(repair);
    }

    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteRepair(long id){
        repairService.delete(repairService.get(id));
    }

}