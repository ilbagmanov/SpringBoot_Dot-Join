package ru.itis.dotjoinrestapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String tel;

    @Column(insertable = false, nullable = false, columnDefinition = "bool default false")
    private boolean isBanned = false;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AccountRole> roles;

    @ManyToMany(mappedBy = "accounts")
    private List<Course> courses;

}
