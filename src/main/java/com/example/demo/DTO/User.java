package com.example.demo.DTO;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Column(name = "age")
    private Long age;

    @Column(name = "name")
    private String name;

    public User() {
    }



    public User(Long id,Long age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
