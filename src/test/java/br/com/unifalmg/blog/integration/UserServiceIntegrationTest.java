package br.com.unifalmg.blog.integration;

import br.com.unifalmg.blog.entity.User;
import br.com.unifalmg.blog.exception.UserNotFoundException;
import br.com.unifalmg.blog.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    @DisplayName("#findById >When yhe id is null > Throw an exception")
    void findByIdWhenIsNullThrowAnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                service.findById(null));
    }

    @Test
    @DisplayName("#findById > When the id is not null > When a user is found > return the user")
    void findByIdWhenTheIdIsNotNullWhenAUserIsFoundReturnTheUser() {
        User user = service.findById(6);
        Assertions.assertAll(
                () -> Assertions.assertEquals(6, user.getId()),
                () -> Assertions.assertEquals("Mrs. Dennis Schulist", user.getName())
        );
    }

    @Test
    @DisplayName("#findById >When the id is not null > When no user is found > Thown an exception")
    void findByIdWhentheIdIsNotNullWhenNoUserIsFoundThownAnException(){
        Assertions.assertThrows(UserNotFoundException.class, () ->
                service.findById(11)
        );
    }

}
