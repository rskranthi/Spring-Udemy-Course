package com.caveofprogramming.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.EmailValidator;



public class ValidEmailImpl implements ConstraintValidator<ValidEmail,String> {

	private int min;
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
		min=constraintAnnotation.min();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(email.length()< min)return false;
		
		if(!EmailValidator.getInstance().isValid(email)){
			return false;
		}
			
		
		return true;
	}

}
