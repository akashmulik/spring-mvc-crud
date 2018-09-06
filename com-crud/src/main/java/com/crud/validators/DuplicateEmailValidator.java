package com.crud.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.servicesapi.UserService;

public class DuplicateEmailValidator implements ConstraintValidator<NoDuplicateEmail, String> {

	@Autowired
	private UserService userSrevice;
	
	public boolean isValid(String email, ConstraintValidatorContext context) {

	//	return userSrevice.checkDuplicateEmail(email);
		return true;
	}

}
