package com.example.simple_board.post.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {

    @NotBlank
    private String userName;

    @NotBlank
    @Size(min = 4,max = 4)
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
