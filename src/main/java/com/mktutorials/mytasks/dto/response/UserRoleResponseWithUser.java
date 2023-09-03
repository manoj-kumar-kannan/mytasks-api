package com.mktutorials.mytasks.dto.response;

import com.mktutorials.mytasks.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleResponseWithUser {

    private Integer id;
    private String role;
    private String roleName;
    private List<UserDto> user;
}
