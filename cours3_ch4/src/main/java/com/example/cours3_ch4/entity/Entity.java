package com.example.cours3_ch4.entity;

import lombok.Data;

@Data
public abstract class Entity implements PrimaryKey{

    private Long Id;
}
