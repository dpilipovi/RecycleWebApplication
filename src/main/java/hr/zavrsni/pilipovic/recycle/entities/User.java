package hr.zavrsni.pilipovic.recycle.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="user")
public class User implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 6950100003761418181L;

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="username", unique = true)
    private String username;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;
    @ManyToMany(targetEntity = Authority.class)
    @JoinTable(
            name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
    )
    private Set<Authority> authorities;
    @OneToMany(targetEntity = Recycle.class)
    @JoinTable(
            name = "user_recycle",
            joinColumns = { @JoinColumn(name = "user_id" ), },
            inverseJoinColumns = { @JoinColumn(name = "recycle_id")}
    )
    private Set<Recycle> recycles;


    public User(String name, String lastname, String username, String email, String password, String address, Set<Authority> authorities, Set<Recycle> recycles) {
        this.firstname = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.authorities = authorities;
        this.recycles = recycles;
    }

    public User(){}


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Recycle> getRecycles() {
        return recycles;
    }

    public void setRecycles(Set<Recycle> recycles) {
        this.recycles = recycles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", authorities=" + authorities +
                ", recycles=" + recycles +
                '}';
    }
}