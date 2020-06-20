package hr.zavrsni.pilipovic.recycle.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 6950100003761418181L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    @Column(name="username", unique = true)
    private String username;
    @Column(name="email", unique = true)
    private String email;
    private String password;
    private String address;
    @ManyToMany(targetEntity = Authority.class)
    @JoinTable(
            name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
    )
    private Set<Authority> authorities;

    @OneToMany(targetEntity = Recycle.class, cascade= CascadeType.ALL /*{CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST}*/)
    @JoinTable(
            name = "user_recycle",
            joinColumns = { @JoinColumn(name = "user_id" ), },
            inverseJoinColumns = { @JoinColumn(name = "recycle_id")}
    )
    @JsonIgnoreProperties("user")
    private Set<Recycle> recycles;




    public User(String firstname, String lastname, String username, String address, String password, String email)
    {
        this.firstname = firstname;
        this.password = password;
        this.lastname = lastname;
        this.username = username;
        this.address = address;
        this.email = email;
    }


}