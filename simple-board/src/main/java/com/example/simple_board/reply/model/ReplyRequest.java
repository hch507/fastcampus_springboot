package com.example.simple_board.reply.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ReplyRequest {

    @NotNull
    private Long postId;

    @NotBlank
    private String userName;

    @NotBlank
    @Size(max = 4,min = 4)
    private String password;

    private String status;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
