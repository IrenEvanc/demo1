package com.example.demo.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "surname")
    private String surname;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "username")
    private String username;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "fathersName")
    private String fathersName;

    @Lob @Type(type = "org.hibernate.type.TextType")
    @Column(name = "email")
    private String email;
    public Users() {
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
