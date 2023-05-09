package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_seq_id")
    @SequenceGenerator(name = "user_seq_id", sequenceName = "user_seq_id", allocationSize = 1)
    @Column(name = ("user_id"))
    private Integer userId;
    @Column(name = ("first_name"))
    private String firstName;
    @Column(name = ("last_name"))
    private String lastName;
    private String email;
    private String password;
    @Column(name = ("phone_number"))
    private String phoneNumber;
    private LocalDateTime birthdate;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

    //One users to many cars
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    //1: ManyToMany
    //2: ManyToOne
    //3: OneToMany
    //4: OneToOne

}
