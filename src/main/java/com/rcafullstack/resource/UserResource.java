package com.rcafullstack.resource;

import com.rcafullstack.dto.PropertyDTO;
import com.rcafullstack.dto.UserDTO;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import com.rcafullstack.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

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
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
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

/*
   User user = User.builder().user_Type(userDto.getUser_Type())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .phone_number(userDto.getPhone_number())
                .build();

        int pCount = 0;
        int rCount = 0;
        for (PropertyDTO p : userDto.getProperties()) {
            user.getProperties().add(modelMapper.map(p, Property.class));
            for (Repair r : user.getProperties().get(pCount).getRepairs()) {
                user.getProperties().get(rCount).getRepairs().add(r);
                rCount++;
            }
        }
        pCount++;

 */