package hr.zavrsni.pilipovic.recycle.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private Set<String> authorities;
    private Set<Recycle> user_recycle;


}