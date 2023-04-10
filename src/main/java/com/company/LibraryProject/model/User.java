package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = ("card_id"))
    private Integer cardId;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "card_id", insertable = false, updatable = false)
    private Card card;

    //@Enumerated(EnumType.STRING)
    private String gender;

    //1: ManyToMany
    //2: ManyToOne
    //3: OneToOne
    //4: OneToMany

}
