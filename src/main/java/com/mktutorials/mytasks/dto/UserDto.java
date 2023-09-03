package com.mktutorials.mytasks.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String email;
}
