package com.moviesite.movieProject.service.interfaces;

import com.moviesite.movieProject.dto.UserCreatedDto;
import com.moviesite.movieProject.dto.UserDto;
import java.util.List;

public interface IUserService{
    UserDto getUserById(Long id);
    List<UserDto> getUsers();
    UserDto createdUser(UserCreatedDto userCreatedDto);
    UserCreatedDto updateUser(Long id,UserCreatedDto userUpdatedDto);
    UserDto deleteUserById(Long id);

}
