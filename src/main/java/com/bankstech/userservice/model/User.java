package com.bankstech.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.*;

@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = @UniqueConstraint(
                name = "username_unique",
                columnNames = "username"
        )
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "username")
    private String username;

    @Column( name = "password")
    private String password;

    //@ManyToMany( mappedBy = "users")
    @ManyToMany( fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();


}
