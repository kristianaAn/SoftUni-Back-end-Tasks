package com.softuni.mobilele.validations.loginUserMatcher;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = LoginUserValidator.class)
public @interface LoginUserMatcher {

    String message() default "Username or Password do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
