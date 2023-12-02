package br.com.unifalmg.blog.controller.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest implements Serializable {

    private String name;

    private String username;

    private String phone;

    private String email;

    private String website;
}
