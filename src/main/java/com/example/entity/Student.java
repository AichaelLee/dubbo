package com.example.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by aichaellee on 2018/11/20.
 */
@Data
public class Student {
    @ApiModelProperty(value="用户名",name="name",example="张三")
    private String name;
    @ApiModelProperty(value="学院",name="academy",example="计算机学院")
    private String academy;
    @ApiModelProperty(value="入学时间",name="enterTime",example="2013-09-10")
    private String enterTime;
    @ApiModelProperty(value="年级",name="grage",example="大学一年级")
    private String grage;
}
