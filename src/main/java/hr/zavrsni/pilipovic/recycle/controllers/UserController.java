package hr.zavrsni.pilipovic.recycle.controllers;

import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import hr.zavrsni.pilipovic.recycle.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hr.zavrsni.pilipovic.recycle.security.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/user")
public class UserController
{


    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/current-user")
    public ResponseEntity<UserDTO> getCurrentUser()
    {
        return SecurityUtils.getCurrentUserUsername()
                .map(
                        username -> userService.findByUsername(username)
                        .map(ResponseEntity::ok)
                        .orElseGet(
                                () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                        )
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                );
    }


    @PutMapping
    public ResponseEntity<UserDTO> editUser(@Valid @RequestBody UserCommand editedUser)
    {
        return userService.editUser(editedUser).map(
                user -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(user))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserCommand user)
    {
        return userService.addUser(user).map(
                _user -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(_user))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

}