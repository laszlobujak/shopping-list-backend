package hu.elte.shoppinglist.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "shoppinglists")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn
    private User owner;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "shoppinglist")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Item> items;

    @ManyToMany(mappedBy = "contributions")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<User> contributors;
}
