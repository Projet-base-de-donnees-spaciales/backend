package ilisi.ma.projetmoveanddescover.user.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ilisi.ma.projetmoveanddescover.events.repository.entities.Evenement;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
//@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @NotNull
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role",cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<User>();



    public Role(Long aLong, String name) {
        this.id= aLong;
        this.name= name;
    }
}
