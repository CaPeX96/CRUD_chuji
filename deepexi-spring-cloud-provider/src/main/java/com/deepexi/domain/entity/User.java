package com.deepexi.domain.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private Long gmtCreate;
    private Long gmtModified;
}
