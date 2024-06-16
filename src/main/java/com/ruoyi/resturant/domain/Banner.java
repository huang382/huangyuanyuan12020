package com.ruoyi.resturant.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "轮播图实体",description = "轮播图实体")
public class Banner {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty("轮播图id")
    private  Long id;
    @ApiModelProperty("轮播图名称")
    @NotBlank(message = "图片名称不能为空")
    @Size(max = 10,min = 2,message = "图片名称在2-10个字符之间")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @ApiModelProperty("轮播图图片")
    @NotBlank(message = "图片不能为空")
    private String pic;
    @ApiModelProperty("轮播图图片网址")
    private String target_url;

    public String getTarget_url() {
        return target_url;
    }

    public void setTarget_url(String target_url) {
        this.target_url = target_url;
    }
    @ApiModelProperty("轮播图图片排序")
    private String  sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    @ApiModelProperty("轮播图图片位置")
    private String  status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
