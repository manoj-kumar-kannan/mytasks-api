package com.mktutorials.mytasks.controller;

import com.mktutorials.mytasks.constant.AppConstant;
import com.mktutorials.mytasks.dto.request.AddUserRoleRequest;
import com.mktutorials.mytasks.dto.request.UpdateUserRoleRequest;
import com.mktutorials.mytasks.dto.response.UserRoleResponse;
import com.mktutorials.mytasks.dto.response.UserRoleResponseWithUser;
import com.mktutorials.mytasks.utils.ResponseHandler;
import com.mktutorials.mytasks.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserRoleById(@PathVariable Integer id) {
        UserRoleResponse userRoleResponse = userRoleService.getUserRoleById(id);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userRoleResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllUserRole() {
        List<UserRoleResponse> userRoleResponses = userRoleService.getAllUserRole();
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userRoleResponses, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getAllUserRoleWithUsers() {
        List<UserRoleResponseWithUser> userRoleResponseWithUsers = userRoleService.getAllUserRoleWithUsers();
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userRoleResponseWithUsers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addUserRole(@Valid @RequestBody AddUserRoleRequest addUserRoleRequest) {
        UserRoleResponse userRoleResponse = userRoleService.addUserRole(addUserRoleRequest);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userRoleResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Object> updateUserRole(@Valid @RequestBody UpdateUserRoleRequest updateUserRoleRequest) {
        UserRoleResponse userRoleResponse = userRoleService.updateUserRole(updateUserRoleRequest);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, userRoleResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserRoleById(@PathVariable Integer id) {
        String result = userRoleService.deleteUserRoleById(id);
        return ResponseHandler.Builder(AppConstant.SUCCESS_RESPONSE_MESSAGE, result, HttpStatus.OK);
    }
}
