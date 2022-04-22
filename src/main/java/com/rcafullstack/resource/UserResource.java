package com.rcafullstack.resource;

import com.rcafullstack.dto.UserDTO;
import com.rcafullstack.model.User;
import com.rcafullstack.service.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/user")
public class UserResource {

    //@Inject
    private ModelMapper modelMapper = new ModelMapper();
    @Inject
    private UserService userService;

    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("userId") long userId) {
        return convertToDto(userService.get(userId));
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();
        for (User u : userService.getAll()) {
            list.add(convertToDto(u));
        }
        return list;
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User saveUser(UserDTO user) {
        return userService.create(convertToEntity(user));
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(UserDTO user) {
        return userService.update(convertToEntity(user));
    }

    @Path("/")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(long id) {
        userService.delete(userService.get(id));
    }

    private UserDTO convertToDto(User user) {
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        return userDto;
    }

    private User convertToEntity(UserDTO userDto) {
        User user = modelMapper.map(userDto, User.class);

        if (userDto.getId() != null) {
            User oldUser = userService.get(userDto.getId());
            user.setId(oldUser.getId());
        }
        return user;
    }
}