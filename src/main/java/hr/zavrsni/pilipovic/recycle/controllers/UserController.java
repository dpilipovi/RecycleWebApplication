package hr.zavrsni.pilipovic.recycle.controllers;

import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserDTO;
import hr.zavrsni.pilipovic.recycle.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import hr.zavrsni.pilipovic.recycle.security.SecurityUtils;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.List;


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
                        .status(HttpStatus.CREATED)
                        .body(_user))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username){

        userService.deleteByUsername(username);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> findAll()
    {
        return userService.findAll();
    }


    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username)
    {
        return userService.findByUsername(username).map(
                        user ->
                            ResponseEntity
                                    .status(HttpStatus.OK)
                                    .body(user))

                        .orElseGet(
                        () ->   ResponseEntity
                                    .status(HttpStatus.NOT_FOUND)
                                    .build()
                        );
    }


    @PutMapping("makeAdmin/{username}")
    public ResponseEntity<UserDTO> makeAdmin(@PathVariable String username)
    {
        return userService.makeAdmin(username).map(
                user -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(user))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

}