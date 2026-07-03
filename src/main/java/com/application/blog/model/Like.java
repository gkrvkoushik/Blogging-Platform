package com.application.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="like",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"userid","blogid"})
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="blogid")
    private Blog blog;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userid")
    private User user;


}
