package hr.zavrsni.pilipovic.recycle.entities;


import javax.validation.constraints.*;
import java.io.Serializable;


public class UserCommand implements Serializable {

    @NotNull(message="Id must not be null")
    private long id;
    @NotBlank(message = "First name must not be empty")
    private String firstname;
    @NotBlank(message = "Last name must not be empty")
    private String lastname;
    @NotBlank(message = "email must not be empty")
    private String email;
    @NotBlank(message = "Address must not be empty")
    private String address;
    @NotBlank(message = "Username must not be empty")
    private String username;
    @NotBlank(message = "Password must not be empty")
    private String password;

    public UserCommand(@NotNull(message="Id must not be null") long id, @NotBlank(message = "First name must not be empty") String firstname, @NotBlank(message = "Last name must not be empty") String lastname, @NotBlank(message = "email must not be empty") String email, @NotBlank(message = "Address must not be empty") String address, @NotBlank(message = "Username must not be empty") String username, @NotBlank(message = "Password must not be empty") String password) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public UserCommand(@NotBlank(message = "First name must not be empty") String firstname, @NotBlank(message = "Last name must not be empty") String lastname, @NotBlank(message = "email must not be empty") String email, @NotBlank(message = "Address must not be empty") String address, @NotBlank(message = "Username must not be empty") String username, @NotBlank(message = "Password must not be empty") String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public UserCommand(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
