package com.mktutorials.mytasks.controller;

import com.mktutorials.mytasks.constant.AppConstant;
import com.mktutorials.mytasks.dto.request.UpdateUserRequest;
import com.mktutorials.mytasks.dto.request.AddUserRequest;
import com.mktutorials.mytasks.dto.response.UserResponseWithUserRole;
import com.mktutorials.mytasks.utils.ResponseHandler;
import com.mktutorials.mytasks.dto.response.UserResponse;
import com.mktutorials.mytasks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Object> saveUser(@Valid @RequestBody AddUserRequest addUserRequest) {
        UserResponse userResponse = userService.createUser(addUserRequest);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllUsers() {
        List<UserResponse> users = userService.getAllUser();
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, users, HttpStatus.OK);
    }

    @GetMapping("/user-role")
    public ResponseEntity<Object> getAllUsersWithUserRole() {
        List<UserResponseWithUserRole> users = userService.getAllUserWithUserRole();
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, users, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        UserResponse userResponse = userService.updateUser(updateUserRequest);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        String result = userService.deleteUserById(id);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, result, HttpStatus.OK);
    }

    @GetMapping("/deactivate/{id}")
    public ResponseEntity<Object> deactivateUser(@PathVariable Long id) {
        String result = userService.deActivateUser(id);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, result, HttpStatus.OK);
    }

}
