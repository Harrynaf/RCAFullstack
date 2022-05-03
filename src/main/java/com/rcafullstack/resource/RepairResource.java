package com.rcafullstack.resource;

import com.rcafullstack.dto.PropertyDTO;
import com.rcafullstack.dto.RepairDTO;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.service.RepairService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


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
    @Path("/property/{propertyId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RepairDTO> getRepairByProperty(@PathParam("propertyId") long propertyId){
        List<RepairDTO> list = new ArrayList<>();
        for (Repair r:repairService.getRepairByPropertyId(propertyId)
        ) {list.add(convertToDto(r));
        }
        return list;
    }
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RepairDTO> getAllRepair() {
        List<RepairDTO> list = new ArrayList<>();
        for (Repair r : repairService.getAll()) {
            list.add(convertToDto(r));
        }
        return list;
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
    public void deleteRepair(RepairDTO repair){
        repairService.delete(repairService.get(repair.getId()));
    }
    private RepairDTO convertToDto(Repair repair) {
        RepairDTO repairDto = modelMapper.map(repair, RepairDTO.class);
        return repairDto;
    }

    private Repair convertToEntity(RepairDTO repairDto) {
        Repair repair = modelMapper.map(repairDto, Repair.class);

        if (repairDto.getId() != null) {
            Repair oldRepair = repairService.get(repairDto.getId());
            repair.setId(oldRepair.getId());
        }
        return repair;
    }
}