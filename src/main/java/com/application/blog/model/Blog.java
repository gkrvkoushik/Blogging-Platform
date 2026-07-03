package com.application.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogid;

    @Column(nullable = false)
    private String title;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userid")
    private User author;

    private String category;

    private String description;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "blog")
    private List<Comment> comments;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
