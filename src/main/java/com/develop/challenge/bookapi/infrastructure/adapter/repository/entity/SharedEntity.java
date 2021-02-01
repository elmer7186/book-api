package com.develop.challenge.bookapi.infrastructure.adapter.repository.entity;

import com.develop.challenge.bookapi.domain.model.shared.PrivilegeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(SharedCompositeKey.class)
@Table(name = "SHARED")
public class SharedEntity {

    @Id
    private long userId;

    @Id
    private long albumId;

    @Column(nullable = false)
    private PrivilegeType privilege;

}
