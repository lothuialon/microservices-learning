package com.lothuialon.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDTO {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
