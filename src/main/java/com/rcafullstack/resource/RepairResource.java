package com.rcafullstack.resource;

import com.rcafullstack.dto.RepairDTO;
import com.rcafullstack.dto.UserDTO;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import com.rcafullstack.service.RepairService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/repair")
public class RepairResource {

    //@Inject
    private ModelMapper modelMapper = new ModelMapper();
    @Inject
    private RepairService repairService;

    @Path("/{repairId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RepairDTO getRepair(@PathParam("repairId") long repairId){
        return convertToDto(repairService.get(repairId));
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Repair saveRepair(RepairDTO repair){
        return repairService.create(convertToEntity(repair));
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Repair updateRepair(RepairDTO repair){
        return repairService.update(convertToEntity(repair));
    }

    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteRepair(long id){
        repairService.delete(repairService.get(id));
    }
    private RepairDTO convertToDto(Repair repair) {
        RepairDTO repairDto = modelMapper.map(repair, RepairDTO.class);
        return repairDto;
    }

    private Repair convertToEntity(RepairDTO repairDto) {
        Repair repair = modelMapper.map(repairDto, Repair.class);

        if (repairDto.getRepairId() != null) {
            Repair oldRepair = repairService.get(repairDto.getRepairId());
            repair.setRepairId(oldRepair.getRepairId());
        }
        return repair;
    }
}