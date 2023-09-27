package com.nva.server.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForClientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;
}
