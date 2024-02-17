package com.softuni.mobilele.validations.passMatcher;

import com.softuni.mobilele.domain.dtos.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PasswordMatcher implements ConstraintValidator<PasswordsMatch, UserDTO> {

    private String password;
    private String confirmPassword;
    private String message;

    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.password = constraintAnnotation.password();
        this.confirmPassword = constraintAnnotation.confirmPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(userDTO);
        Object propertyValue1 = beanWrapper.getPropertyValue(this.password);
        Object propertyValue2 = beanWrapper.getPropertyValue(this.confirmPassword);

        if (propertyValue1 != null && propertyValue1.equals(propertyValue2)) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(confirmPassword)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
