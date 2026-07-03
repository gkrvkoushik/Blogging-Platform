package com.application.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Email(message = "Provide proper email")
    private String email;

    @Min(value = 6)
    private String password;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "user")
    private List<Blog> blogs;


}
