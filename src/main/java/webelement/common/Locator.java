package webelement.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Locator {
    String id() default "";

    String name() default "";

    String link() default "";

    String dom() default "";

    String xpath() default "";

    String css() default "";
}
