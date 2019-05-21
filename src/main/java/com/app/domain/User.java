package com.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public User() { }

    public User(String name, String img, String img_dir) {
        this.name = name;
        this.img = img;
        this.img_dir = img_dir;
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

  /*  public Path getFilePath() {
        if (img == null || img_dir == null) { return null; }
        return Paths.get(img_dir, img);
    }*/
}
