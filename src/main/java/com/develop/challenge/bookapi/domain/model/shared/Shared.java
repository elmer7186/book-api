package com.develop.challenge.bookapi.domain.model.shared;

import com.develop.challenge.bookapi.domain.exception.RequiredValueException;
import com.develop.challenge.bookapi.domain.model.ArgumentValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.REQUIRED_VALUE_ALBUM_ID;
import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.REQUIRED_VALUE_PRIVILEGE;
import static com.develop.challenge.bookapi.domain.exception.NotificationCodeType.REQUIRED_VALUE_USER_ID;

@Getter
@Setter
@NoArgsConstructor
public class Shared {

    private long userId;
    private long albumId;
    private PrivilegeType privilege;

    public Shared(long userId, long albumId, PrivilegeType privilege) {
        ArgumentValidator.validateRequired(userId,
                () -> new RequiredValueException(REQUIRED_VALUE_USER_ID));
        ArgumentValidator.validateRequired(albumId,
                () -> new RequiredValueException(REQUIRED_VALUE_ALBUM_ID));
        ArgumentValidator.validateRequired(privilege,
                () -> new RequiredValueException(REQUIRED_VALUE_PRIVILEGE));
        this.userId = userId;
        this.albumId = albumId;
        this.privilege = privilege;
    }
}
