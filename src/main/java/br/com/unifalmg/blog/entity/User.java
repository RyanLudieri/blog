package br.com.unifalmg.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108018", name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String phone;

    private String email;

    private String website;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

//    @OneToMany(mappedBy = "user")
//    private List<Comment> comments;
}