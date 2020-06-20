package hr.zavrsni.pilipovic.recycle.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand implements Serializable {

   // @NotNull(message="Id must not be null")
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
    @NotNull(message = "Recycles must not be null")
    private Set<Recycle> recycles;


}
