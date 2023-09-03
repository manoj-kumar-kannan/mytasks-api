package com.mktutorials.mytasks.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequest {

    @NotBlank(message = "FirstName should not be empty")
    @Size(min = 3, max = 25, message = "FirstName should contains only min 3 and max 25 characters")
    private String firstName;

    private String middleName;

    @NotBlank(message = "LastName should not be empty")
    @Max(value = 25, message = "LastName should contains only max 25 characters")
    private String lastName;

    @NotBlank(message = "Email should not be empty")
    @Email(message = "Invalid email id")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Min(value = 5, message = "Password should contain min 5 characters")
    private String password;

    @NotBlank(message = "UserRole required")
    private Integer userRoleId;
}
