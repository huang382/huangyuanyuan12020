package com.ruoyi.resturant.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "店铺的实体",description = "店铺实体")
public class ResShop extends BaseEntity {
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@ApiModelProperty("编号")
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    @Size(max = 6,min = 2,message = "店铺姓名在2-6个字符之间")
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @ApiModelProperty("地址")
    private String address;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    @ApiModelProperty("联系电话")
    private String contact;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    @ApiModelProperty("封面")
    private String cover;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @ApiModelProperty("店铺详情")
    private String detail;

    public Long getStar() {
        return star;
    }

    public void setStar(Long star) {
        this.star = star;
    }
    @ApiModelProperty("评分")
    private Long star;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    @ApiModelProperty("店主ID")
    private Long ownerId;

    public ResShop() {

    }
    public ResShop(Long id, String name, String address, String contact)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
