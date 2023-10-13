package com.nva.server.validators;

import com.nva.server.annotations.NotEmptyMultipartFile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileNotEmptyValidator implements ConstraintValidator<NotEmptyMultipartFile, MultipartFile> {
    @Override
    public void initialize(NotEmptyMultipartFile constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        return multipartFile != null && !multipartFile.isEmpty();
    }
}
