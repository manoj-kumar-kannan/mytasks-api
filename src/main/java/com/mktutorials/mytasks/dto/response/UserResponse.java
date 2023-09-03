package com.mktutorials.mytasks.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String email;
}
