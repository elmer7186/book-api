package com.develop.challenge.bookapi.application.dto.shared;

import com.develop.challenge.bookapi.domain.model.shared.PrivilegeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharedDto {

    private long userId;
    private long albumId;
    private PrivilegeType privilegeType;

}
