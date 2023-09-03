package com.mktutorials.mytasks.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleRequest {

    @NotNull(message = "Id required")
    private Integer id;

    @NotBlank(message = "Role required")
    @Size(min = 2, max = 50, message = "Min 2 Required and Max 50 Characters allowed")
    private String role;
}
