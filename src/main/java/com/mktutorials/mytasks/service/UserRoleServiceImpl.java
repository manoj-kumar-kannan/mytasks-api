package com.mktutorials.mytasks.service;

import com.mktutorials.mytasks.constant.AppConstant;
import com.mktutorials.mytasks.dto.request.AddUserRoleRequest;
import com.mktutorials.mytasks.dto.request.UpdateUserRoleRequest;
import com.mktutorials.mytasks.dto.response.UserRoleResponse;
import com.mktutorials.mytasks.dto.response.UserRoleResponseWithUser;
import com.mktutorials.mytasks.entity.UserRole;
import com.mktutorials.mytasks.exception.ResourceNotFoundException;
import com.mktutorials.mytasks.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRoleResponse getUserRoleById(Integer id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Role"));
        return modelMapper.map(userRole, UserRoleResponse.class);
    }

    @Override
    public List<UserRoleResponse> getAllUserRole() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRole -> modelMapper.map(userRole, UserRoleResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleResponseWithUser> getAllUserRoleWithUsers() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRole -> modelMapper.map(userRole, UserRoleResponseWithUser.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleResponse addUserRole(AddUserRoleRequest addUserRoleRequest) {
        UserRole userRole = modelMapper.map(addUserRoleRequest, UserRole.class);
        UserRole newUserRole = userRoleRepository.save(userRole);
        return modelMapper.map(newUserRole, UserRoleResponse.class);
    }

    @Override
    public UserRoleResponse updateUserRole(UpdateUserRoleRequest updateUserRoleRequest) {
        UserRole existingUserRole = userRoleRepository.findById(updateUserRoleRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User Role"));
        existingUserRole.setRole(updateUserRoleRequest.getRole());
        UserRole updatedUserRole = userRoleRepository.save(existingUserRole);
        return modelMapper.map(updatedUserRole, UserRoleResponse.class);
    }

    @Override
    public String deleteUserRoleById(Integer id) {
        userRoleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Role"));
        userRoleRepository.deActivateUserRole(id, AppConstant.USER_DE_ACTIVE);
        return AppConstant.USER_ROLE_DELETED;
    }
}
