package com.tungpv.example.resource;


import com.tungpv.example.Model.User;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    public static List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1, "user1", "user1@gmail.com"), new User(2, "user2", "user2@gmail.com")
    ));

    @GET
    public List<User> getUsers() {
        return userList;
    }

    @GET
    @Path("/{user_id}")
    public User getUser(@PathParam("user_id") String userId){
        for (User x : userList) {
            if (x.getId() == Integer.parseInt(userId)) {
                return x;
            }
        }
        return null;
    }

    @POST
    public Boolean createUser(User user) {
        user.setId(userList.size() + 1);
        userList.add(user);
        return true;
    }

    @PUT
    @Path("/{user_id}")
    public Object updateUser(@PathParam("user_id") String userId, User user) {
        for (User x : userList) {
            if (x.getId() == Integer.parseInt(userId)) {
                x.setEmail(user.getEmail());
                x.setFullName(user.getFullName());
                return x;
            }
        }
        return new ServiceUnavailableException();
    }

    @DELETE
    @Path("/{user_id}")
    public boolean deleteUser(@PathParam("user_id") String userId) {
        for (User x : userList) {
            if (x.getId() == Integer.parseInt(userId)) {
                userList.remove(x);
                return true;
            }
        }
        return false;
    }
}
