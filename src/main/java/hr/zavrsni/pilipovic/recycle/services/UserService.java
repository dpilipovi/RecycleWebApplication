package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDTO> editUser(UserCommand editedUser);

    Optional<UserDTO> findByUsername(String username);

    Optional<UserDTO> addUser(UserCommand user);

    void deleteByUsername(String username);

    List<UserDTO> findAll();
}
