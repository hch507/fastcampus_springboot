package com.example.cours3_ch4.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public abstract class Entity implements PrimaryKey{

    @Getter
    @Setter
    private Long id;
}
