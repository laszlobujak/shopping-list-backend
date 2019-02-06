package hu.elte.shoppinglist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

//    public enum Role {
//        ROLE_GUEST, USER, ROLE_ADMIN
//    }

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ShoppingList> shoppingLists;

    @ManyToMany
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "USER_CONTRIBUTIONS",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ShoppingList> contributions;
}
