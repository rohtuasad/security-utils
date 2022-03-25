package ru.rohtuasad.securityutils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import ru.rohtuasad.securityutils.SecurityUtilsServicesConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SecurityUtilsServicesConfig.class)
public @interface EnableSecurityUtils {

}
