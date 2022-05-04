package com.rcafullstack.resource;

import com.rcafullstack.dto.PropertyDTO;
import com.rcafullstack.dto.RepairDTO;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import com.rcafullstack.service.RepairService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/repair")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RepairResource {
    private static final String DELETED="Deleted.";
    private static final String NOTFOUND="Not found.";
    //@Inject
    private ModelMapper modelMapper = new ModelMapper();
    @Inject
    private RepairService repairService;

    @Path("/{repairId}")
    @GET
    public RepairDTO getRepair(@PathParam("repairId") long repairId){
        return convertToDto(repairService.get(repairId));
    }
    @Path("/property/{propertyId}")
    @GET
    public List<RepairDTO> getRepairByProperty(@PathParam("propertyId") long propertyId){
        List<RepairDTO> list = new ArrayList<>();
        for (Repair r:repairService.getRepairByPropertyId(propertyId)
        ) {list.add(convertToDto(r));
        }
        return list;
    }
    @Path("/all")
    @GET
    public List<RepairDTO> getAllRepair() {
        List<RepairDTO> list = new ArrayList<>();
        for (Repair r : repairService.getAll()) {
            list.add(convertToDto(r));
        }
        return list;
    }
    @Path("/")
    @POST
    public Repair saveRepair(RepairDTO repair)
    {try {return repairService.create(convertToEntity(repair));}
    catch(EntityNotFoundException e){Repair repairError =new Repair(); repairError.setId(-1L); return repairError;}}

    @Path("/")
    @PUT
    public Repair updateRepair(RepairDTO repair)
    {try {return repairService.update(convertToEntity(repair));}
        catch(EntityNotFoundException e){Repair repairError =new Repair(); repairError.setId(-1L); return repairError;}}

    @Path("/{repairId}")
    @DELETE
    public String deleteRepair(@PathParam("repairId") long repairId)
    {try {repairService.delete(repairService.get(repairId)); return DELETED;}
    catch(Exception e){return NOTFOUND;}}
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