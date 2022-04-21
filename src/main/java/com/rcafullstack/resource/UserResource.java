package com.rcafullstack.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import com.rcafullstack.service.UserService;
import org.hibernate.Hibernate;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/user")
public class UserResource {

    @Inject
    private UserService userService;

    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") long userId){
        return userService.get(userId);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User saveUser(User user){
        return userService.create(user);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user){
        return userService.update(user);
    }

    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(long id){
         userService.delete(userService.get(id));
    }

}