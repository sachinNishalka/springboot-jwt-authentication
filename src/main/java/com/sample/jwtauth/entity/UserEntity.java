package com.sample.jwtauth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String nationality;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dob;
    private String gender;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    TODO: find out what a hashset is
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

//    TODO: in the role entity, we dont need above explanation, the above code will create another table and the table will have the user_id and the role_id column names

}
