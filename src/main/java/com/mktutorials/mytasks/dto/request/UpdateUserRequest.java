package com.mktutorials.mytasks.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {

    private Long id;

    @NotBlank(message = "FirstName should not be empty")
    @Size(min = 3, max = 25, message = "FirstName should contains only min 3 and max 25 characters")
    private String firstName;

    private String middleName;

    @NotBlank(message = "LastName should not be empty")
    @Size(max = 25, message = "LastName should contains only max 25 characters")
    private String lastName;
}
