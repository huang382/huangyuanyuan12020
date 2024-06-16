package com.ruoyi.example.pojo;

import java.util.Map;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private  Integer age;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public String[] getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String[] orderIds) {
        this.orderIds = orderIds;
    }

    private String[] orderIds;

    public Map<String, String> getPhone() {
        return phone;
    }

    public void setPhone(Map<String, String> phone) {
        this.phone = phone;
    }

    private Map<String,String> phone;

}
