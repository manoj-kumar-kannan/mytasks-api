package com.mktutorials.mytasks.service;

import com.mktutorials.mytasks.constant.AppConstant;
import com.mktutorials.mytasks.dto.request.UpdateUserRequest;
import com.mktutorials.mytasks.dto.request.AddUserRequest;
import com.mktutorials.mytasks.dto.response.UserResponse;
import com.mktutorials.mytasks.dto.response.UserResponseWithUserRole;
import com.mktutorials.mytasks.entity.User;
import com.mktutorials.mytasks.entity.UserRole;
import com.mktutorials.mytasks.exception.ResourceNotFoundException;
import com.mktutorials.mytasks.repository.UserRepository;
import com.mktutorials.mytasks.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user"));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAllByIsActive(AppConstant.USER_ACTIVE);
        if (users.size() == 0) {
            throw new ResourceNotFoundException("users");
        }
        return users.stream().map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponseWithUserRole> getAllUserWithUserRole() {
        List<User> users = userRepository.findAllByIsActive(AppConstant.USER_ACTIVE);
        if (users.size() == 0) {
            throw new ResourceNotFoundException("users");
        }
        return users.stream().map(user -> modelMapper.map(user, UserResponseWithUserRole.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse createUser(AddUserRequest addUserRequest) {
        UserRole userRole = userRoleRepository.findById(addUserRequest.getUserRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("User Role"));
        User user = modelMapper.map(addUserRequest, User.class);
        user.setUserRole(userRole);
        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {
        User existingUser = userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User"));
        existingUser.setFirstName(updateUserRequest.getFirstName());
        existingUser.setMiddleName(updateUserRequest.getMiddleName());
        existingUser.setLastName(updateUserRequest.getLastName());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return AppConstant.USER_DELETED;
    }

    @Override
    public String deActivateUser(Long id) {
        userRepository.updateIsActive(id, AppConstant.USER_ROLE_DE_ACTIVE);
        return AppConstant.USER_DEACTIVATED;
    }
}
