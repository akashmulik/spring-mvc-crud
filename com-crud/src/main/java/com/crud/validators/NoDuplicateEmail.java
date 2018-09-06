package com.crud.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DuplicateEmailValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface NoDuplicateEmail {
	
	String message() default "Email already registered!";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
