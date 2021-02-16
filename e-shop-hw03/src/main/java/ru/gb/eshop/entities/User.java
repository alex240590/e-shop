package ru.gb.eshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;

    @NotBlank
    @Column(name = "u_login")
    private String username;

    @NotBlank
    @Column(name = "u_pass")
    private String password;

    @NotBlank
    @Column(name = "u_first_name")
    private String firstName;

    @Column(name = "u_last_name")
    private String lastName;

    @NotBlank
    @Column(name = "u_email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
