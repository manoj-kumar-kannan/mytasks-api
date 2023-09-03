package com.mktutorials.mytasks.service;

import com.mktutorials.mytasks.dto.request.UpdateUserRequest;
import com.mktutorials.mytasks.dto.request.AddUserRequest;
import com.mktutorials.mytasks.dto.response.UserResponse;
import com.mktutorials.mytasks.dto.response.UserResponseWithUserRole;

import java.util.List;

public interface UserService {

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUser();

    List<UserResponseWithUserRole> getAllUserWithUserRole();

    UserResponse createUser(AddUserRequest addUserRequest);

    UserResponse updateUser(UpdateUserRequest updateUserRequest);

    String deleteUserById(Long id);

    String deActivateUser(Long id);
}
