package com.develop.challenge.bookapi.infrastructure.adapter.external.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EmailExternalDto {

    private String recipient;
    private String subject;
    private String message;

}
