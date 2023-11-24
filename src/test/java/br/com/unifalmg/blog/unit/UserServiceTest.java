package br.com.unifalmg.blog.unit;

import br.com.unifalmg.blog.entity.User;
import br.com.unifalmg.blog.exception.UserNotFoundException;
import br.com.unifalmg.blog.repository.UserRepository;
import br.com.unifalmg.blog.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    @DisplayName("#findById >When yhe id is null > Throw an exception")
    void findByIdWhenIsNullThrowAnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                service.findById(null));
    }

    @Test
    @DisplayName("#findById >When the id is not null > When a user is found > Return the user")
    void findByIdWhenTheIdIsNotNullWhenAUserIsFoundReturnTheUser(){
        when(repository.findById(1)).thenReturn(Optional.of(User.builder()
                        .id(1)
                        .name("Ryan")
                        .username("Ryan123")
                .build()));
        User response = service.findById(1);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, response.getId()),
                () -> Assertions.assertEquals("Ryan", response.getName()),
                () -> Assertions.assertEquals("Ryan123", response.getUsername())
        );
    }

    @Test
    @DisplayName("#findById >When the id is not null > When no user is found > Thown an exception")
    void findByIdWhentheIdIsNotNullWhenNoUserIsFoundThownAnException(){
        when(repository.findById(2)).thenReturn(Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () ->
                service.findById(2)
        );
    }






}
