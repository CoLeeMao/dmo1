package annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@SuppressWarnings("haha")
public @interface MyAnnotation {

    String[] value();
}
