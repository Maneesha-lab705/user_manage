package com.example.usermanagement.api;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApi {
   @Autowired
   private final UserService userService;
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.createUser(userDTO));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(exception.getMessage());
        }
    }
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.updsteauader(userDTO));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(exception.getMessage());
        }
    }

    @GetMapping("/getUser")
    public UserDTO verifyUser(@RequestParam("id") String id){
           return userService.getUser(id);
    }

    @GetMapping("/getUserList")
    public List<UserDTO> verifyUser(){
        return userService.getUserList();
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") String id){
        return userService.deleteUser(id);
    }


}
