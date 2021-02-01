package com.develop.challenge.bookapi.domain.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ArgumentValidator {

    public static void validateRequired(Object argument, Supplier<Throwable> throwableSupplier) {
        if (argument == null) {
            throwableSupplier.get();
        }
    }

    public static void validateRequired(long argument, Supplier<Throwable> throwableSupplier) {
        if (argument == 0) {
            throwableSupplier.get();
        }
    }

}
