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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("Nmmmm");
                });
        assertThat(exception.getMessage()).isEqualTo("Length less than 8");
    }

    @Test
    void whenLengthOver32() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("Nmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
                });
        assertThat(exception.getMessage()).isEqualTo("Length over 32");
    }

    @Test
    void whenForbiddenWords() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("mUsErmmmh68%");
                });
        assertThat(exception.getMessage()).isEqualTo("Do not use qwerty, 12345, password, admin, user");
    }

    @Test
    void whenForbiddenNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("!2345msErm12345mm");
                });
        assertThat(exception.getMessage()).isEqualTo("Do not use qwerty, 12345, password, admin, user");
    }

    @Test
    void whenNolowercase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("@nmmmmmm1");
                });
        assertThat(exception.getMessage()).isEqualTo("No uppercase");
    }

    @Test
    void whenNoUppercase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("@NMMMMMM1");
                });
        assertThat(exception.getMessage()).isEqualTo("No lowercase");
    }

    @Test
    void whenNoNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("@NMMMM$MMm$");
                });
        assertThat(exception.getMessage()).isEqualTo("No numbers");
    }

    @Test
    void whenNoSpecialS() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    validate("1NMMMMMMm2");
                });
        assertThat(exception.getMessage()).isEqualTo("No special characters");
    }

    @Test
    void whenPasswordCorrect() {
        assertThat(validate("12.TTTzzz")).isEqualTo("PASSWORD GOOD");
    }
}