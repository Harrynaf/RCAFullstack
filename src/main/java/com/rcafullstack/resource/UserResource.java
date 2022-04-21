package com.rcafullstack.resource;

import com.rcafullstack.model.Property;
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

    @Path("/")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    
    @Path("/links")
    @GET
    @Produces("text/html")
    public String links() {
        return "<a href='http://localhost:8080/jakartaeshop-1.0-SNAPSHOT/user/1'>links</a>";
    }


    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") int userId){

        Hibernate.initialize(userService.get(userId).getProperties());
        for (Property p:userService.get(userId).getProperties()
             ) {Hibernate.initialize(p);
        }
        return userService.get(userId);
    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User saveUser(User user){
        return userService.create(user);
    }
    

}