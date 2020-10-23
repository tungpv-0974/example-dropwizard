package com.tungpv.example.resource.views;

import com.tungpv.example.Model.User;
import io.dropwizard.views.View;
import lombok.Getter;

import java.util.List;

@Getter
public class UserView extends View {
    private List<User> userList;

    public UserView(List<User> users){
        super("index.html");
        this.userList = users;
    }

}
