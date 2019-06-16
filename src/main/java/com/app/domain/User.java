package com.app.domain;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String img;

    private String img_dir;

    @Embedded
    private Address address;

    public User() { }

    public User(String name, String img, String img_dir, Address address) {
        this.name = name;
        this.img = img;
        this.img_dir = img_dir;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public void setImg_dir(String img_dir) {
        this.img_dir = img_dir;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", img_dir='" + img_dir + '\'' +
                ", address=" + address +
                '}';
    }
}
