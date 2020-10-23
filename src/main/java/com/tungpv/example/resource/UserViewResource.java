package com.tungpv.example.resource;

import com.tungpv.example.Model.User;
import com.tungpv.example.resource.views.UserView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/users")
public class UserViewResource {

    public static List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1, "user1", "user1@gmail.com"), new User(2, "user2", "user2@gmail.com")
    ));

    @GET
    public UserView getUsers() {
        return new UserView(userList);
    }
}
