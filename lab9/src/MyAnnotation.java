import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME) // Політика утримання
@Target({ElementType.METHOD, ElementType.TYPE}) // Обмеження застосування
public @interface MyAnnotation {
    String value() default "Default Value";
    int version() default 1;
}
