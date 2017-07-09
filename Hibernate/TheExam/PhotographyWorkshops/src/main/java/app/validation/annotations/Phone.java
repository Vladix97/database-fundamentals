package app.validation.annotations;

import app.validation.PhoneValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Phone {

    String message() default "Invalid Phone";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
