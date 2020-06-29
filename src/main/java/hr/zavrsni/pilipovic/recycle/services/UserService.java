package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.User;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface UserService {

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Optional<UserDTO> editUser(UserCommand editedUser);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Optional<UserDTO> findByUsername(String username);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Optional<UserDTO> addUser(UserCommand user);

    @Secured({"ROLE_ADMIN"})
    void deleteByUsername(String username);

    @Secured({"ROLE_ADMIN"})
    List<UserDTO> findAll();

    @Secured({"ROLE_ADMIN"})
    Optional<UserDTO> makeAdmin(String username);
}
