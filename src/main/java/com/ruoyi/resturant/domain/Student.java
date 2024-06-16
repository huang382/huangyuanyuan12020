package com.ruoyi.resturant.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "学生实体",description = "学生实体")
public class Student {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@ApiModelProperty("学生id")

    private  Long id;
    @ApiModelProperty("学生学号")
    @NotNull(message = "学号不能为空")

    private String sno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ApiModelProperty("学生姓名")
    @NotBlank(message = "姓名不能为空")
    @Size(max = 6,min = 2,message = "学生姓名2-6个字符之间")
    private String name;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @ApiModelProperty("学生性别")
    private String sex;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
