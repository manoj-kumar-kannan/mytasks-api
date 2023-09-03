package com.mktutorials.mytasks.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRoleRequest {
    @NotEmpty(message = "Role required")
    @Size(min = 2, max = 50, message = "Min 2 Required and Max 50 Characters allowed")
    private String role;
}
