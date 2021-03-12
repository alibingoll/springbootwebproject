package com.moviesite.movieProject.controller;

import com.moviesite.movieProject.dto.UserCreatedDto;
import com.moviesite.movieProject.dto.UserDto;

import com.moviesite.movieProject.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        modelMap.put("name","aliekber");
        return "home";
    }
    /*______________________________________CREATED USER______________________________________________*/
    /*@PostMapping(path = "/user",consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User createdUser=userService.createdUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }*/
    @PostMapping(path = "/user",consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreatedDto userCreatedDto)
    {
        userService.createdUser(userCreatedDto);
        return ResponseEntity.ok(userCreatedDto);
    }
    /*______________________________________/CREATED USER______________________________________________*/

    /*______________________________________UPDATED USER______________________________________________*/

    @PutMapping(path = "/user/{Id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserCreatedDto> updateUser(@PathVariable(value = "Id") Long id,@RequestBody UserCreatedDto userUpdateDto){
        final UserCreatedDto userDto=userService.updateUser(id,userUpdateDto);
        return ResponseEntity.ok(userDto);

    }

    /*______________________________________/UPDATED USER______________________________________________*/

    /*______________________________________DELETE USER BY ID______________________________________________*/
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") Long id){
        UserDto deletedUser=userService.deleteUserById(id);
        return ResponseEntity.ok(deletedUser);
    }


    /*______________________________________/DELETE USER BY ID______________________________________________*/

    /*______________________________________GET USER BY ID______________________________________________*/
    /*@GetMapping(path = "/user/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "Id") Long Id) {
        User user = userService.getUserById(Id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
        @GetMapping(path = "/user/{Id}")
        public ResponseEntity<UserDto> getUserById(@PathVariable(value = "Id") Long Id) {
            UserDto user = userService.getUserById(Id);
            return ResponseEntity.ok(user);
        }
    /*______________________________________/GET USER BY ID______________________________________________*/

    /*______________________________________GET USER BY USERNAME______________________________________________*/



    /*______________________________________/GET USER BY USERNAME______________________________________________*/



    /*______________________________________GET ALL USERS________________________________________________*/
    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDto>> getUsers() {
            final List<UserDto> users=userService.getUsers();
        return ResponseEntity.ok(users);
    }
    /*______________________________________/GET ALL USERS________________________________________________*/



}
