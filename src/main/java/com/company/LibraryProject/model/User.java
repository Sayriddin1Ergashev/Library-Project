package com.company.LibraryProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("users"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("user_id"))
    private Integer userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    @Column(name = ("phone_number"))
    private String phoneNumber;
    @Column(name = ("card_id"))
    private Integer cardId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "card_id", insertable = false, updatable = false)
    private Card card;

    @Column(name = ("birth_date"))
    private LocalDate birthdate;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
    //1: @OneToOne
    //2: @OneToMany
    //3: @ManyToOne
    //4: @ManyToMany

}
