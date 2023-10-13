package com.nva.server.annotations;

import com.nva.server.validators.MultipartFileNotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MultipartFileNotEmptyValidator.class)
public @interface NotEmptyMultipartFile {
    String message() default "Vui lòng chọn một tệp tin.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

