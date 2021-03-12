package com.moviesite.movieProject.controller;

import com.moviesite.movieProject.model.User;
import com.moviesite.movieProject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping(path = "users/login",consumes = "application/json", produces = "application/json")
    public String loginUserr(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
       try{
           final User currentUser=userRepository.findByUserName(user.getUserName());
           if (user.getPassword().equals(currentUser.getPassword())){
               HttpSession session=request.getSession(true);
               session.setAttribute("fname",currentUser.getFirstName());
               session.setAttribute("lname",currentUser.getLastName());
               session.setAttribute("uname",currentUser.getUserName());
               return "Giriş başarılı";
           }else {
               return "Giriş başarısız";
           }
       }
       catch (Exception e){
           return "Hata : kullanıcı bulunamadı";

       }
    }

    @GetMapping(path = "users/profile")
    public String myProfile(HttpServletRequest request){
        try {
            HttpSession session=request.getSession(false);
            String fName=(String)session.getAttribute("fname");
            String lName=(String)session.getAttribute("lname");
            String uName=(String)session.getAttribute("uname");
            return "Kullanıcı adı : "+ uName+"\nAdı : "+fName+"\nSoyadınınız : "+lName;

        }catch (Exception e){
            return "Hata oluştu, Giriş yapmamış olabilirsiniz.";
        }


    }
    @GetMapping(path = "users/logout")
    public String logout (HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "Çıkış başarılı";
    }

















    @GetMapping(path = "/lhe")
    public String lhello(){
        return "LHELLO";
    }


}
