package com.example.Nice_Kyrgyzstan.controller;

import com.example.Nice_Kyrgyzstan.dto.user.UserRegisterRequest;
import com.example.Nice_Kyrgyzstan.dto.user.UserResponse;
import com.example.Nice_Kyrgyzstan.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest userRequest){
        userService.register(userRequest);
    }
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserRegisterRequest userRequest){
        userService.updateById(id, userRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        userService.deleteById(id);

    }



}
