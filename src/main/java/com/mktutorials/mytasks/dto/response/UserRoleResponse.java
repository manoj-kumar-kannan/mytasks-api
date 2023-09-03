package com.mktutorials.mytasks.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleResponse {

    private Integer id;
    private String role;
    private String roleName;
}
