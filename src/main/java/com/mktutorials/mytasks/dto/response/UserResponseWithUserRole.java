package com.mktutorials.mytasks.dto.response;

import com.mktutorials.mytasks.dto.UserRoleDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseWithUserRole {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String email;
    private UserRoleDto userRole;
}
