package com.mktutorials.mytasks.service;

import com.mktutorials.mytasks.dto.request.AddUserRoleRequest;
import com.mktutorials.mytasks.dto.request.UpdateUserRoleRequest;
import com.mktutorials.mytasks.dto.response.UserRoleResponse;
import com.mktutorials.mytasks.dto.response.UserRoleResponseWithUser;

import java.util.List;

public interface UserRoleService {

    UserRoleResponse getUserRoleById(Integer id);
    List<UserRoleResponse> getAllUserRole();
    List<UserRoleResponseWithUser> getAllUserRoleWithUsers();
    UserRoleResponse addUserRole(AddUserRoleRequest addUserRoleRequest);
    UserRoleResponse updateUserRole(UpdateUserRoleRequest updateUserRoleRequest);
    String deleteUserRoleById(Integer id);
}
