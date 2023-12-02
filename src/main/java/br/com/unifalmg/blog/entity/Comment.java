//package br.com.unifalmg.blog.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@Table(schema = "db2022108018", name= "comment")
//public class Comment implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String name;
//
//    private String email;
//
//    private String body;
//
//    private Integer post_id;
//
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//
//}