package com.example.cours3_ch4.user.model;

import com.example.cours3_ch4.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {

    private String name;

    private int score;
}
