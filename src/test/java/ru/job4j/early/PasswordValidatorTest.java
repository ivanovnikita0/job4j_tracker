package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.early.PasswordValidator.*;
import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @Test
    void whenEmptyNameInvalid() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Empty line");
    }

    @Test
    void whenLengthLessThan8() {
        assertThat(validate("Nmmmm")).isEqualTo("Length less than 8");
    }

    @Test
    void whenLengthOver32() {
        assertThat(validate("Nmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")).isEqualTo("Length over 32");
    }

    @Test
    void whenForbiddenWords() {
        assertThat(validate("mUsErmmmh68%")).isEqualTo("Do not use qwerty, 12345, password, admin, user");
    }

    @Test
    void whenForbiddenNumbers() {
        assertThat(validate("!2345msErm12345mm")).isEqualTo("Do not use qwerty, 12345, password, admin, user");
    }

    @Test
    void whenNolowercase() {
        assertThat(validate("@nmmmmmm1")).isEqualTo("No uppercase");
    }

    @Test
    void whenNoUppercase() {
        assertThat(validate("@NMMMMMM1")).isEqualTo("No lowercase");
    }

    @Test
    void whenNoNumbers() {
        assertThat(validate("@NMMMM$MMm$")).isEqualTo("No numbers");
    }

    @Test
    void whenNoSpecialS() {
        assertThat(validate("1NMMMMMMm2")).isEqualTo("No special characters");
    }

    @Test
    void whenPasswordCorrect() {
        assertThat(validate("12.TTTzzz")).isEqualTo("PASSWORD GOOD");
    }
}