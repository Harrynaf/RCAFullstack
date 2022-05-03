package com.rcafullstack.resource;

import com.rcafullstack.dto.PropertyDTO;
import com.rcafullstack.model.Property;
import com.rcafullstack.service.PropertyService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/property")
public class PropertyResource {

    //@Inject
    private ModelMapper modelMapper = new ModelMapper();
    @Inject
    private PropertyService propertyService;

    @Path("/{propertyId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PropertyDTO getProperty(@PathParam("propertyId") long propertyId){
        return convertToDto(propertyService.get(propertyId));
    }
    @Path("/user/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<PropertyDTO> getPropertyByUser(@PathParam("userId") long propertyId){
        List<PropertyDTO> list = new ArrayList<>();
        for (Property p:propertyService.getByUser(propertyId)
             ) {list.add(convertToDto(p));
        }
        return list;
    }
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<PropertyDTO> getAllProperty() {
        List<PropertyDTO> list = new ArrayList<>();
        for (Property r : propertyService.getAll()) {
            list.add(convertToDto(r));
        }
        return list;
    }
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Property saveProperty(PropertyDTO property){
        return propertyService.create(convertToEntity(property));
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Property updateProperty(PropertyDTO property){
        return propertyService.update(convertToEntity(property));
    }

    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProperty(PropertyDTO property){
        propertyService.delete(propertyService.get(property.getId()));
    }
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