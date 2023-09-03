package com.mktutorials.mytasks.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    private String role;
    private String roleName;
}
