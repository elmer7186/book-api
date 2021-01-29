package com.develop.challenge.bookapi.infrastructure.adapter.repository.entity;

import com.develop.challenge.bookapi.domain.model.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    private long id;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType rol;

    @Column(nullable = false)
    private boolean enabled;

}
