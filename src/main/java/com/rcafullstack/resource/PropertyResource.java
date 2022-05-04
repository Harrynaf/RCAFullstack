package com.rcafullstack.resource;

import com.rcafullstack.dto.PropertyDTO;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.service.PropertyService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/property")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropertyResource {
    private static final String DELETED="Deleted.";
    private static final String NOTFOUND="Not found.";
    //@Inject
    private ModelMapper modelMapper = new ModelMapper();
    @Inject
    private PropertyService propertyService;

    @Path("/{propertyId}")
    @GET
    public PropertyDTO getProperty(@PathParam("propertyId") long propertyId){
        return convertToDto(propertyService.get(propertyId));
    }
    @Path("/user/{userId}")
    @GET
    public List<PropertyDTO> getPropertyByUser(@PathParam("userId") long propertyId){
        List<PropertyDTO> list = new ArrayList<>();
        for (Property p:propertyService.getByUser(propertyId)
             ) {list.add(convertToDto(p));
        }
        return list;
    }
    @Path("/all")
    @GET
    public List<PropertyDTO> getAllProperty() {
        List<PropertyDTO> list = new ArrayList<>();
        for (Property r : propertyService.getAll()) {
            list.add(convertToDto(r));
        }
        return list;
    }
    @Path("/")
    @POST
    public Property saveProperty(PropertyDTO property)
    {try {return propertyService.create(convertToEntity(property));}
    catch(EntityNotFoundException e){Property propertyError =new Property(); propertyError.setId(-1L); return propertyError;}}

    @Path("/")
    @PUT
    public Property updateProperty(PropertyDTO property)
    {try {return propertyService.update(convertToEntity(property));}
    catch(EntityNotFoundException e){Property propertyError =new Property(); propertyError.setId(-1L); return propertyError;}}

    @Path("/{propertyId}")
    @DELETE
    public String deleteProperty(@PathParam("propertyId") long propertyId)
    {try {propertyService.delete(propertyService.get(propertyId)); return DELETED;}
    catch(Exception e){return NOTFOUND;}}
    private PropertyDTO convertToDto(Property property) {
        PropertyDTO propertyDto = modelMapper.map(property, PropertyDTO.class);
        return propertyDto;
    }

    private Property convertToEntity(PropertyDTO propertyDto) {
        Property property = modelMapper.map(propertyDto, Property.class);

        if (propertyDto.getId() != null) {
            Property oldProperty = propertyService.get(propertyDto.getId());
            property.setId(oldProperty.getId());
        }
        return property;
    }
}