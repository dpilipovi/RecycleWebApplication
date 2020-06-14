package hr.zavrsni.pilipovic.recycle.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="authority")
public class Authority  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(targetEntity = User.class, mappedBy = "authorities")
    private List<User> users;

    public Authority(long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Authority(){}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

 
    
}
