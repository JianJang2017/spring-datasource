package com.jianzhang.db.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private String name;

    private int age;

    private String sex;

    private Date createTime;
}
