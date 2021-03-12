package com.moviesite.movieProject.service;

import com.moviesite.movieProject.dto.UserCreatedDto;
import com.moviesite.movieProject.dto.UserDto;
import com.moviesite.movieProject.exception.NotFoundException;
import com.moviesite.movieProject.model.User;
import com.moviesite.movieProject.repository.IUserRepository;
import com.moviesite.movieProject.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

   /* @Override
    public User createdUser(User user) {
        return userRepository.save(user);
    }*/
   @Override
   public UserDto createdUser(@Valid UserCreatedDto userCreatedDto) {
       final User user=new User();
       user.setFirstName(userCreatedDto.getFirstName());
       user.setLastName(userCreatedDto.getLastName());
       user.setMail(userCreatedDto.getMail());
       user.setPassword(userCreatedDto.getPassword());
       user.setUserName(userCreatedDto.getUserName());
       user.setRegistrationDate(userCreatedDto.getRegistrationDate());
       userRepository.save(user);
       return UserDto.of(user);
   }

    @Override
    public UserCreatedDto updateUser(Long id, UserCreatedDto userUpdatedDto) {
        final User user=userRepository.findById(id).orElseThrow(()-> new NotFoundException("Kullanıcı Bulunamadı"));
        user.setFirstName(userUpdatedDto.getFirstName());
        user.setLastName(userUpdatedDto.getLastName());
        user.setUserName(userUpdatedDto.getUserName());
        user.setMail(userUpdatedDto.getMail());
        user.setPassword(userUpdatedDto.getPassword());
        userRepository.save(user);
        return  userUpdatedDto;

    }

    @Override
    public UserDto deleteUserById(Long id) {
        final User user=userRepository.findById(id).orElseThrow(()-> new NotFoundException("Kullanıcı Bulunamadı"));
        userRepository.deleteById(user.getId());
        return UserDto.of(user);
    }

    /* @Override
     public User getUserById(Long id) {
         Optional<User> user=userRepository.findById(id);
         if (user.isPresent()){
             return user.get();
         }
         return null;
     }*/
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserDto::of).collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new NotFoundException("Kullanıcı Bulunamadı"));
        return UserDto.of(user);
    }



}
