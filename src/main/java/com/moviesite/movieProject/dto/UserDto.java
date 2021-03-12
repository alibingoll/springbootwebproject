package com.moviesite.movieProject.dto;

import com.moviesite.movieProject.model.User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public final class UserDto implements Serializable {
    private static final long serialVersionUID=1L;
    private final String firstName;
    private final String lastName;
    private final String userName;

    private UserDto(String firstName,String lastName,String userName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
    }
    public static UserDto of(User user){
        return new UserDto(user.getFirstName(),user.getLastName(),user.getUserName());
    }

}
