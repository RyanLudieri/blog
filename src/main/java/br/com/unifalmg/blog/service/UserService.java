package br.com.unifalmg.blog.service;

import br.com.unifalmg.blog.entity.User;
import br.com.unifalmg.blog.exception.InvalidUserException;
import br.com.unifalmg.blog.exception.UserNotFoundException;
import br.com.unifalmg.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User findById(Integer id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("Id null when fetching for an user.");
        }
        return repository.findById(id).orElseThrow(() ->
             new UserNotFoundException(
                String.format("No user found id %d",id))
        );
    }



    public User add(User user) {
        if(Objects.isNull(user) || Objects.isNull(user.getName())
                || Objects.isNull(user.getUsername()) || Objects.isNull(user.getEmail())|| user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getName().isEmpty()) {
            throw new InvalidUserException("Usuario incorreto!");
        }
        return repository.save(user);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public User updateUser(Integer id, User newUser){
        User existingUser = repository.findById(id).
                orElseThrow(() -> new UserNotFoundException("Usuario não encontrado!"));

        existingUser.setName(newUser.getName());
        existingUser.setUsername(newUser.getUsername());
        existingUser.setEmail(newUser.getEmail());
        existingUser.setPhone(newUser.getPhone());
        existingUser.setWebsite(newUser.getWebsite());
        return repository.save(existingUser);
    }







}
